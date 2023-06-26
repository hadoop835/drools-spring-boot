package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;

/**
 * 规矩条件
 * @author chenzhh
 */
@Table(value ="dr_condition_when_item" )
public class ConditionWhenItemEntity extends BaseEntity {
    /**
     * 字段主键
     */
   private  String   fieldId;
    /**
     * 操作符
     */
   private  String  operatorId;
    /**
     *参数值
     */
   private  String  value;

    /**
     * 条件 && ||
     */
    private  String   symbol;
    /**
     * When
     */
    private Long  conditionWhenId;

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getConditionWhenId() {
        return conditionWhenId;
    }

    public void setConditionWhenId(Long conditionWhenId) {
        this.conditionWhenId = conditionWhenId;
    }
}
