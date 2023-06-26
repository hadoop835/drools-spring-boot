package io.github.hadoop835.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.github.hadoop835.dao.entity.OperatorEntity;
import io.github.hadoop835.dao.mapper.OperatorMapper;
import io.github.hadoop835.service.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 操作符业务逻辑实现类
 * @author Administrator
 */
@Service
public class OperatorServiceImpl implements OperatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OperatorServiceImpl.class);
    @Resource
    private OperatorMapper  operatorMapper;

    @PostConstruct
    private  void  init(){
//        Map<String,String> datas = Maps.newHashMap();
//        datas.put(">","大于");
//        datas.put("<","小于");
//        datas.put(">=","大于等于");
//        datas.put("<=","小于等于");
//        datas.put("==","等于");
//        datas.put("!=","不等于");
//        datas.put("contains","检查一个Fact对象的某个属性值是否包含一个指定的对象值");
//        datas.put("not contains","检查一个Fact对象的某个属性值是否不包含一个指定的对象值");
//        datas.put("memberOf","判断一个Fact对象的某个属性是否在一个或多个集合中");
//        datas.put("not memberOf","判断一个Fact对象的某个属性是否不在一个或多个集合中");
//        datas.put("matches","判断一个Fact对象的属性是否与提供的标准的Java正则表达式进行匹配");
//        datas.put("not matches","判断一个Fact对象的属性是否不与提供的标准的Java正则表达式进行匹配");
//        List<OperatorEntity> operatorEntities = Lists.newArrayList();
//        int i =0;
//        for(String name: datas.keySet()){
//            OperatorEntity operatorEntity = new OperatorEntity();
//            operatorEntity.setName(datas.get(name));
//            operatorEntity.setValue(name);
//            operatorEntity.setVersion(1);
//            operatorEntity.setSort(++i);
//            operatorEntities.add(operatorEntity);
//        }
//        operatorMapper.insertBatch(operatorEntities);
//        LOGGER.info("初始化操作成功");

    }
}
