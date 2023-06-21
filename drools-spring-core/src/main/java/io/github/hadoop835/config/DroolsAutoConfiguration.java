package io.github.hadoop835.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

/**
 * @author Administrator
 */
@Configuration
@MapperScan(basePackages = {"io.github.hadoop835.dao.mapper"})
public class DroolsAutoConfiguration {






}
