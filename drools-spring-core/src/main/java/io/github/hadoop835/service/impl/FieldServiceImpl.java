package io.github.hadoop835.service.impl;

import com.google.common.collect.Lists;
import com.mybatisflex.core.query.QueryWrapper;
import io.github.hadoop835.dao.entity.FieldEntity;
import io.github.hadoop835.dao.mapper.FieldMapper;
import io.github.hadoop835.dto.FieldDto;
import io.github.hadoop835.service.FieldService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static io.github.hadoop835.dao.entity.table.FieldEntityTableDef.FIELD_ENTITY;

/**
 * @author Administrator
 */
@Service
public class FieldServiceImpl implements FieldService {
    @Resource
    private FieldMapper  fieldMapper;

    /**
     * 创建
     * @param fieldDtos
     */
    @Override
    public void createField(List<FieldDto> fieldDtos) {
        List<FieldEntity> fieldEntities = Lists.newArrayList();
        for(FieldDto fieldDto: fieldDtos){
            FieldEntity fieldEntity = new FieldEntity();
            fieldEntity.setVersion(1);
            fieldEntity.setFieldName(fieldDto.getFieldName());
            fieldEntity.setFieldType(fieldDto.getFieldType());
            fieldEntity.setName(fieldDto.getName());
            fieldEntity.setRulesId(fieldDto.getRulesId());
            fieldEntities.add(fieldEntity);
        }
        fieldMapper.insertBatch(fieldEntities);
    }

    /**
     *
     * @param rulesId
     * @return
     */
    @Override
    public List<FieldDto> getFieldByRulesId(Long rulesId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.where(FIELD_ENTITY.RULES_ID.eq(rulesId));
        List<FieldEntity> fieldEntities =  fieldMapper.selectListByQuery(queryWrapper);
        return FieldEntity.toFieldDtoList(fieldEntities);
    }


    @Override
    public  FieldDto  getFieldDtoById(List<FieldDto> fieldDtos, Long id){
          for(FieldDto fieldDto : fieldDtos){
              if(fieldDto.getId().equals(id)){
                  return fieldDto;
              }
          }
          return null;
    }

}
