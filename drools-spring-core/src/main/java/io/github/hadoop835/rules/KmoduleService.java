package io.github.hadoop835.rules;

import cn.hutool.core.io.FileUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import io.github.hadoop835.dao.entity.RulesEntity;
import io.github.hadoop835.freemarker.FreemarkerTemplate;
import io.github.hadoop835.service.RulesService;
import io.github.hadoop835.util.PackageJarUtil;
import org.drools.core.util.IoUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

/**
 * 生成资源包
 * @author chenzhh
 */
@Component
public class KmoduleService {
    @Resource
    private FreemarkerTemplate velocityTemplate;
    @Resource
    private RulesService rulesService;

    @Value("${temp.file.path}")
    private String  tempFile;

    public  void  buildPackege(String  instanceId) throws IOException {
        RulesEntity rulesEntity =  rulesService.getRulesEntity(instanceId);
        Preconditions.checkNotNull(rulesEntity,instanceId+",查询数据为空");
        Kmodule kmodule = new Kmodule();
        kmodule.setPomArtifactId(rulesEntity.getInstanceId());
        kmodule.setPomGroupId(rulesEntity.getInstanceId());
        kmodule.setPomVersion(rulesEntity.getVersion()+"");
        kmodule.setKbaseName("rules-"+rulesEntity.getInstanceId());
        kmodule.setKsessionName("ksession-rules-"+rulesEntity.getInstanceId());
        Map<String,Object> result = Maps.newHashMap();
        result.put("module",kmodule);
        //基础目录
        File  baseFile = new File(tempFile+File.separator+instanceId);

        File metaInfFile = new File(baseFile.getAbsolutePath()+File.separator+"META-INF"+File.separator+"kmodule.xml");
        String module =  velocityTemplate.create("kmodule.ftl",result);
        FileUtil.writeString(module,metaInfFile,"UTF-8");

        File mavenFile = new File(baseFile.getAbsolutePath()+File.separator+"META-INF"+File.separator+"maven"+File.separator+"pom.properties");
        String pom =  velocityTemplate.create("pom.ftl",result);
        FileUtil.writeString(pom,mavenFile,"UTF-8");

        //规则文件目录
        String rules =  velocityTemplate.create("rules.ftl",result);
        File rulesFile = new File(baseFile.getAbsolutePath()+File.separator+"rules"+File.separator+"rules.drl");
        FileUtil.writeString(rules,rulesFile,"UTF-8");

        File jarFile = PackageJarUtil.createTempJar(baseFile.getAbsolutePath(),baseFile.getParentFile().getAbsolutePath());
        byte [] content = IoUtils.readBytes(jarFile);
        rulesEntity.setRules(content);
        rulesService.update(rulesEntity);
        FileUtil.del(baseFile);
        FileUtil.del(jarFile);

        System.out.println(content);
    }

}
