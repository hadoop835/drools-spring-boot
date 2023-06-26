package io.github.hadoop835.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import io.github.hadoop835.dao.entity.ConditionEntity;
import io.github.hadoop835.dao.entity.ConditionWhenEntity;
import io.github.hadoop835.dao.entity.ConditionWhenItemEntity;
import io.github.hadoop835.dao.mapper.ConditionMapper;
import io.github.hadoop835.dao.mapper.ConditionWhenItemMapper;
import io.github.hadoop835.dao.mapper.ConditionWhenMapper;
import io.github.hadoop835.dto.*;
import io.github.hadoop835.service.ConditionService;
import io.github.hadoop835.service.FieldService;
import io.github.hadoop835.service.OperatorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static io.github.hadoop835.dao.entity.table.ConditionEntityTableDef.CONDITION_ENTITY;
import static io.github.hadoop835.dao.entity.table.ConditionWhenEntityTableDef.CONDITION_WHEN_ENTITY;
import static io.github.hadoop835.dao.entity.table.ConditionWhenItemEntityTableDef.CONDITION_WHEN_ITEM_ENTITY;

/**
 * @author chenzhh
 */
@Service
public class ConditionServiceImpl implements ConditionService {
    @Resource
    private ConditionMapper  conditionMapper;
    @Resource
    private ConditionWhenMapper conditionWhenMapper;
    @Resource
    private ConditionWhenItemMapper conditionWhenItemMapper;
    @Resource
    private OperatorService operatorService;
    @Resource
    private FieldService  fieldService;

    /**
     *  创建规则
     * @param conditionDtos
     * @return
     */
    @Override
    public void createCondition(List<ConditionDto> conditionDtos) {
        for(ConditionDto conditionDto : conditionDtos){
            ConditionEntity  conditionEntity = new ConditionEntity();
            conditionEntity.setVersion(1);
            conditionEntity.setName(conditionDto.getName());
            conditionEntity.setAction(conditionDto.getAction());
            conditionEntity.setRulesId(conditionDto.getRulesId());
            conditionMapper.insert(conditionEntity);
            //保存when
            List<ConditionWhenDto>  conditionWhenDtos = conditionDto.getConditionWhenDtos();
            for(ConditionWhenDto conditionWhenDto:conditionWhenDtos){
                ConditionWhenEntity conditionWhenEntity = new ConditionWhenEntity();
                conditionWhenEntity.setVarName(conditionWhenDto.getVarName());
                conditionWhenEntity.setVarValue(conditionWhenDto.getVarValue());
                conditionWhenEntity.setSymbol(conditionWhenDto.getSymbol());
                conditionWhenEntity.setVersion(1);
                conditionWhenEntity.setConditionId(conditionEntity.getId());
                conditionWhenMapper.insert(conditionWhenEntity);

                //
                List<ConditionWhenItemEntity> conditionWhenItemEntities = Lists.newArrayList();
                List<ConditionWhenItemDto> conditionWhenItemDtos = conditionWhenDto.getConditionWhenItemDtos();
                for(ConditionWhenItemDto conditionWhenItemDto:conditionWhenItemDtos){
                    ConditionWhenItemEntity conditionWhenItemEntity = new ConditionWhenItemEntity();
                    conditionWhenItemEntity.setFieldId(conditionWhenItemDto.getFieldId());
                    conditionWhenItemEntity.setOperatorId(conditionWhenItemDto.getOperatorId());
                    conditionWhenItemEntity.setValue(conditionWhenItemDto.getValue());
                    conditionWhenItemEntity.setSymbol(conditionWhenItemDto.getSymbol());
                    conditionWhenItemEntity.setConditionWhenId(conditionWhenEntity.getId());
                    conditionWhenItemEntity.setVersion(1);
                    conditionWhenItemEntities.add(conditionWhenItemEntity);
                }
                conditionWhenItemMapper.insertBatch(conditionWhenItemEntities);
            }
        }
    }

    /**
     *
     * 查询规则模板
     * @param rulesId
     * @return
     */
    @Override
    public List<ConditionDto> getConditionByRulesId(Long rulesId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.where(CONDITION_ENTITY.RULES_ID.eq(rulesId));
        List<ConditionEntity> conditionEntities = conditionMapper.selectListByQuery(queryWrapper);
        Set<Long>  conditionIds = Sets.newHashSet();
        List<ConditionDto> conditionDtos = Lists.newArrayList();
        for(ConditionEntity conditionEntity :conditionEntities){
            conditionIds.add(conditionEntity.getId());
            conditionDtos.add(conditionEntity.toConditionDto());
        }

        QueryWrapper whenQueryWrapper = new QueryWrapper();

        whenQueryWrapper.where(CONDITION_WHEN_ENTITY.CONDITION_ID.in(conditionIds));
        List<ConditionWhenEntity>  conditionWhenEntities = conditionWhenMapper.selectListByQuery(whenQueryWrapper);
        Set<Long>  conditionWhenIds = Sets.newHashSet();
        List<ConditionWhenDto> conditionWhenDtos = Lists.newArrayList();
        for(ConditionWhenEntity conditionWhenEntity : conditionWhenEntities){
            conditionWhenDtos.add(conditionWhenEntity.toConditionWhenDto());
            conditionWhenIds.add(conditionWhenEntity.getId());
        }

        QueryWrapper whenItemQueryWrapper = new QueryWrapper();
        whenQueryWrapper.where(CONDITION_WHEN_ITEM_ENTITY.CONDITION_WHEN_ID.in(conditionWhenIds));
        List<ConditionWhenItemEntity> conditionWhenItemEntities = conditionWhenItemMapper.selectListByQuery(whenItemQueryWrapper);
        //查询操作符
        List<OperatorDto> operatorDtos = operatorService.listAll();
        //查询字段
        List<FieldDto> fieldDtos = fieldService.getFieldByRulesId(rulesId);
        List<ConditionWhenItemDto> conditionWhenItemDtos = Lists.newArrayList();
        for(ConditionWhenItemEntity conditionWhenItemEntity : conditionWhenItemEntities){
            ConditionWhenItemDto conditionWhenItemDto =  conditionWhenItemEntity.toConditionWhenItemDto();
            OperatorDto operatorDto =  operatorService.getOperatorById(operatorDtos,conditionWhenItemDto.getOperatorId());
            if(Objects.nonNull(operatorDto)){
                conditionWhenItemDto.setOperatorValue(operatorDto.getValue());
            }
            FieldDto fieldDto = fieldService.getFieldDtoById(fieldDtos,conditionWhenItemDto.getFieldId());
            if(Objects.nonNull(fieldDto)){
                conditionWhenItemDto.setFieldName(fieldDto.getFieldName());
            }
            conditionWhenItemDtos.add(conditionWhenItemDto);
        }

        for(ConditionDto conditionDto : conditionDtos){
            for( ConditionWhenDto conditionWhenDto : conditionWhenDtos){
                if(conditionDto.getId().equals(conditionWhenDto.getConditionId())){
                    conditionDto.addConditionWhenDto(conditionWhenDto);
                }
                for(ConditionWhenItemDto conditionWhenItemDto : conditionWhenItemDtos){
                    if(conditionWhenDto.getId().equals(conditionWhenItemDto.getConditionWhenId())){
                        conditionWhenDto.addConditionWhenDto(conditionWhenItemDto);
                    }
                }
            }
        }
        return conditionDtos;
    }

}
