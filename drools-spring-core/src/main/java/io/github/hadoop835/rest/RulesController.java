package io.github.hadoop835.rest;

import com.google.common.collect.Maps;
import io.github.hadoop835.dao.entity.RulesEntity;
import io.github.hadoop835.drools.repository.KieSessionRepository;
import io.github.hadoop835.order.Order;
import io.github.hadoop835.rules.KmoduleService;
import io.github.hadoop835.service.RulesService;
import io.github.hadoop835.freemarker.FreemarkerTemplate;
import io.github.hadoop835.util.PackageJarUtil;
import io.github.hadoop835.vo.RulesVo;
import org.drools.core.util.IoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;

/**
 * @author Administrator
 */
@RestController
@RequestMapping(value = "/v1")
public class RulesController {
    private static  final Logger LOGGER = LoggerFactory.getLogger(RulesController.class);
    @Resource
    private RulesService rulesService;

    @Resource
    private KieSessionRepository kieSessionRepository;

    @Resource
    private FreemarkerTemplate velocityTemplate;
    @Resource
    private KmoduleService kmoduleService;

    /**
     *
     * @param rulesVo
     * @return
     */
    @PostMapping(value = "create")
    public  String  create(@RequestBody  RulesVo  rulesVo) throws IOException {
        RulesEntity rulesEntity = new RulesEntity();
        rulesEntity.setInstanceId(rulesVo.getInstanceId());
        rulesEntity.setName(rulesVo.getName());
        rulesService.save(rulesEntity);
        return "SUCCESS";
    }



    /**
     *
     * @param instanceId
     * @return
     */
    @GetMapping(value = "rules/{instanceId}")
    public  String  getRules(@PathVariable String  instanceId){
        rulesService.getRules(instanceId);
        return null;
    }


    @GetMapping(value = "test/{instanceId}/{amount}")
     public  void test(@PathVariable String  instanceId,@PathVariable Integer amount) throws IOException {
        //kmoduleService.buildPackege(instanceId);
        Order order = new Order();
        order.setAmount(amount);
        kieSessionRepository.insert(order,instanceId);
        LOGGER.info("指定规则引擎后的结果：{}",order.getScore());
     }
}
