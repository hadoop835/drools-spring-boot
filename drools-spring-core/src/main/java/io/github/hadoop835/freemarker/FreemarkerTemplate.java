package io.github.hadoop835.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * ，模板
 * @author chenzhh
 */
@Component
public class FreemarkerTemplate {

    private Configuration configuration;

    @PostConstruct
    private  void  init(){
        configuration = new Configuration(Configuration.getVersion());
        configuration.setClassLoaderForTemplateLoading(FreemarkerTemplate.class.getClassLoader(),"/ftl");
        configuration.setDefaultEncoding("UTF-8");
    }


    /**
     *
     * @param ftl
     * @param values
     * @return
     */
    public  String  create(String ftl, Map<String,Object> values) {
        try(StringWriter sw = new StringWriter()) {
            Template template =  configuration.getTemplate(ftl);
            template.process(values,sw);
            return sw.toString();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return new String();
    }

}
