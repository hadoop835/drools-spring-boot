package io.github.hadoop835.dto;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 */
public class ConditionWhenDto extends  BaseDto{
    /**
     * 变量名称
     */
    private  String  varName;
    /**
     * 变量值
     */
    private  String  varValue;
    /**
     *  连接词 and  or
     */
    private  String   symbol;

    /**
     * 条件
     */
    private  Long  conditionId;

    /**
     *
     */
    private List<ConditionWhenItemDto> conditionWhenItemDtos = Lists.newArrayList();




    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public String getVarValue() {
        return varValue;
    }

    public void setVarValue(String varValue) {
        this.varValue = varValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<ConditionWhenItemDto> getConditionWhenItemDtos() {
        return conditionWhenItemDtos;
    }

    public void setConditionWhenItemDtos(List<ConditionWhenItemDto> conditionWhenItemDtos) {
        this.conditionWhenItemDtos = conditionWhenItemDtos;
    }

    public Long getConditionId() {
        return conditionId;
    }

    public void setConditionId(Long conditionId) {
        this.conditionId = conditionId;
    }

    /**
     *
     * @param conditionWhenItemDto
     */
    public   void   addConditionWhenDto(ConditionWhenItemDto conditionWhenItemDto){
        if(!conditionWhenItemDtos.contains(conditionWhenItemDto)){
             conditionWhenItemDtos.add(conditionWhenItemDto);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConditionWhenDto that = (ConditionWhenDto) o;
        return  Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
