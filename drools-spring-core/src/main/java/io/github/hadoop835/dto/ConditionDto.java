package io.github.hadoop835.dto;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Administrator
 */
public class ConditionDto extends BaseDto{
    private String  name;
    private Long  rulesId;
    private String action;
    /**
     * 保存属性
     */
    private List<ConditionAttrDto> attributeDtos = Lists.newArrayList();
    /**
     * 保存条件
     */
    private List<ConditionWhenDto> conditionWhenDtos= Lists.newArrayList();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRulesId() {
        return rulesId;
    }

    public void setRulesId(Long rulesId) {
        this.rulesId = rulesId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<ConditionWhenDto> getConditionWhenDtos() {
        return conditionWhenDtos;
    }

    public void setConditionWhenDtos(List<ConditionWhenDto> conditionWhenDtos) {
        this.conditionWhenDtos = conditionWhenDtos;
    }

    public List<ConditionAttrDto> getAttributeDtos() {
        return attributeDtos;
    }

    public void setAttributeDtos(List<ConditionAttrDto> attributeDtos) {
        this.attributeDtos = attributeDtos;
    }

    /**
     *
     * @param conditionWhenDto
     */
    public   void   addConditionWhenDto(ConditionWhenDto conditionWhenDto){
        if(!conditionWhenDtos.contains(conditionWhenDto)){
            conditionWhenDtos.add(conditionWhenDto);
        }
    }

    /**
     *
     * @param attributeDto
     */
    public   void   addAttributeDto(ConditionAttrDto attributeDto){
        if(!attributeDtos.contains(attributeDto)){
            attributeDtos.add(attributeDto);
        }
    }
}
