package io.github.hadoop835.service;

import io.github.hadoop835.dto.FieldDto;

import java.util.List;

/**
 * @author Administrator
 */
public interface FieldService {
    /**
     * 保存属性字段
     * @param fieldDtos
     */
    void  createField(List<FieldDto> fieldDtos);

    /**
     *
     * @param rulesId
     * @return
     */
    List<FieldDto>  getFieldByRulesId(Long rulesId);

    /**
     * 查询字段信息
     * @param fieldDtos
     * @param id
     * @return
     */
    FieldDto  getFieldDtoById(List<FieldDto> fieldDtos,Long id);


}
