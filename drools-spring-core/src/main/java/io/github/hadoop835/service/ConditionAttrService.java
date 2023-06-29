package io.github.hadoop835.service;

import io.github.hadoop835.dto.ConditionAttrDto;

import java.util.List;
import java.util.Set;

/**
 * 属性 业务逻辑
 * @author Administrator
 */
public interface ConditionAttrService {

    /**
     * 创建属性
     * @param attributeDtos
     */
    void  createAttribute(List<ConditionAttrDto> attributeDtos);

    /**
     * 根据条件查询属性
     * @param conditionIds
     * @return
     */
    List<ConditionAttrDto> getAttributeDtoByConditionIds(Set<Long> conditionIds);


}
