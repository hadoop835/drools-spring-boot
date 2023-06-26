package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;
import io.github.hadoop835.dto.ConditionWhenDto;

/**
 * 条件
 * @author chenzhh
 */
@Table(value = "dr_condition_when")
public class ConditionWhenEntity extends BaseEntity {
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
     * @return
     */
    public ConditionWhenDto toConditionWhenDto(){
        ConditionWhenDto conditionWhenDto = new ConditionWhenDto();
        conditionWhenDto.setId(getId());
        conditionWhenDto.setVarName(getVarName());
        conditionWhenDto.setVarValue(getVarValue());
        conditionWhenDto.setSymbol(getSymbol());
        conditionWhenDto.setConditionId(getConditionId());
        return conditionWhenDto;
    }

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

    public Long getConditionId() {
        return conditionId;
    }

    public void setConditionId(Long conditionId) {
        this.conditionId = conditionId;
    }
}
