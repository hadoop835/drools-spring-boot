package io.github.hadoop835.service;

import io.github.hadoop835.dto.ConditionDto;

import java.util.List;

/**
 * 条件业务逻辑
 * @author Administrator
 */
public interface ConditionService {
    /**
     * 创建条件
     * @param conditionDtos
     * @return
     */
    void  createCondition(List<ConditionDto> conditionDtos);

    /**
     * 规则查询条件
     * @param rulesId
     * @return
     */
    List<ConditionDto> getConditionByRulesId(Long rulesId);

}
