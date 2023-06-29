package io.github.hadoop835.service.impl;

import com.google.common.collect.Lists;
import com.mybatisflex.core.query.QueryWrapper;
import io.github.hadoop835.dao.entity.ConditionAttrEntity;
import io.github.hadoop835.dao.mapper.ConditionAttrMapper;
import io.github.hadoop835.dto.ConditionAttrDto;
import io.github.hadoop835.service.ConditionAttrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

import static io.github.hadoop835.dao.entity.table.AttributeEntityTableDef.ATTRIBUTE_ENTITY;

/**
 *
 * @author chenzhh
 */
@Service
public class ConditionAttrServiceImpl implements ConditionAttrService {
    @Resource
    private ConditionAttrMapper conditionAttrMapper;


    @Override
    public void createAttribute(List<ConditionAttrDto> attributeDtos) {
        List<ConditionAttrEntity> attributeEntitys = Lists.newArrayList();
        for(ConditionAttrDto attributeDto : attributeDtos){
            ConditionAttrEntity attributeEntity = new ConditionAttrEntity();
            attributeEntity.toAttributeEntity(attributeDto);
            attributeEntitys.add(attributeEntity);
        }
        conditionAttrMapper.insertBatch(attributeEntitys);
    }

    @Override
    public List<ConditionAttrDto> getAttributeDtoByConditionIds(Set<Long> conditionIds) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.where(ATTRIBUTE_ENTITY.CONDITION_ID.in(conditionIds));
        List<ConditionAttrEntity> attributeEntities = conditionAttrMapper.selectListByQuery(queryWrapper);
        List<ConditionAttrDto> attributeDtos = Lists.newArrayList();
        for(ConditionAttrEntity attributeEntity : attributeEntities){
            attributeDtos.add(attributeEntity.toAttributeDto());
        }
        return attributeDtos;
    }
}
