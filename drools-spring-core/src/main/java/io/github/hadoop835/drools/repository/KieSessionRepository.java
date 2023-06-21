package io.github.hadoop835.drools.repository;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.google.common.collect.Maps;
import io.github.hadoop835.dao.entity.RulesEntity;
import io.github.hadoop835.dao.mapper.RulesMapper;
import io.github.hadoop835.drools.KieSessionContext;
import io.github.hadoop835.service.RulesService;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author Administrator
 */
@Service
public class KieSessionRepository {
    /**
     * 本地缓存
     */
    private Map<String, KieSessionContext> kieSessions = Maps.newConcurrentMap();

     /**
     * 规则表
     */
     @javax.annotation.Resource
     private RulesService rulesService;

     private KieServices kieServices;

    /**
     *
     */
    @PostConstruct
    private   void  init(){
        kieServices = KieServices.get();
    }

    /**
     *
     * @param instanceId
     * @return
     */
    private  synchronized KieSession kieContainer(String instanceId){
        RulesEntity rulesEntity =  rulesService.getRulesEntity(instanceId);
        if(Objects.isNull(rulesEntity)){

        }
        Long  updateTime = Timestamp.valueOf(rulesEntity.getUpdateTime()).getTime();
        KieSessionContext kieSessionContext =  kieSessions.get(instanceId);
        if(Objects.isNull(kieSessionContext)){
            KieSession kieSession = createKieSession(instanceId);
            kieSessionContext = new KieSessionContext(kieSession,updateTime);
            kieSessions.put(instanceId,kieSessionContext);
            return kieSession;
        }else{
           Long oldUpdateTime = kieSessionContext.getUpdateTime();
            //已经更新
           if(oldUpdateTime < updateTime){
               KieSession kieSession = createKieSession(instanceId);
               kieSessionContext = new KieSessionContext(kieSession,updateTime);
               kieSessions.put(instanceId,kieSessionContext);
               return kieSession;
           }
           return kieSessionContext.getKieSession();
        }
    }

    /**
     * 创建会话
     * @param instanceId
     * @return
     */
    private  KieSession  createKieSession(String instanceId){
        byte [] rules =  rulesService.getRules(instanceId);
        Resource resource = this.kieServices.getResources().newByteArrayResource(rules);
        KieRepository repository =  this.kieServices.getRepository();
        KieModule kieModule =  repository.addKieModule(resource);
        KieContainer kieContainer =  this.kieServices.newKieContainer(kieModule.getReleaseId());
        KieSession kieSession =  kieContainer.newKieSession();
        return kieSession;
    }

    /**
     *
     * @param object
     * @param instanceId
     */
    public  void insert(Object object,String instanceId) {
        KieSession kieSession = kieContainer(instanceId);
        FactHandle factHandle =  kieSession.insert(object);
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent("", ResourceType.BRL);
        kieSession.fireAllRules();
    }

}
