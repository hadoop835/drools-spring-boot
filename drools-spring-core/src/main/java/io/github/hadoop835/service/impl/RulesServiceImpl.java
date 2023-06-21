package io.github.hadoop835.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import io.github.hadoop835.dao.entity.RulesEntity;
import io.github.hadoop835.dao.mapper.RulesMapper;
import io.github.hadoop835.service.RulesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class RulesServiceImpl implements RulesService {
    @Resource
    private RulesMapper  rulesMapper;


    @Override
    public byte[] getRules(String  instanceId){
        QueryWrapper queryWrapper =QueryWrapper.create()
                .select("rules").where("instance_id=?",new Object[]{instanceId});
        RulesEntity rulesEntity =  rulesMapper.selectOneByQuery(queryWrapper);
        return rulesEntity.getRules();
    }

    @Override
    public RulesEntity getRulesEntity(String instanceId) {
        QueryWrapper queryWrapper =QueryWrapper.create()
                .select("id","name","create_time","update_time","version","instance_id").where("instance_id=?",new Object[]{instanceId});
        RulesEntity rulesEntity =  rulesMapper.selectOneByQuery(queryWrapper);
        return rulesEntity;
    }

    @Override
    public void save(RulesEntity rulesEntity) {
        rulesEntity.setVersion(1);
        rulesMapper.insert(rulesEntity);
    }

    @Override
    public boolean update(RulesEntity rulesEntity) {
       int rs = rulesMapper.update(rulesEntity);
       return rs>0?true:false;
    }


}
