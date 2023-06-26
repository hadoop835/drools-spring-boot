package io.github.hadoop835.dto;

import java.util.Objects;

/**
 * @author Administrator
 */
public class ConditionWhenItemDto extends BaseDto{

    /**
     * 字段主键
     */
    private  Long   fieldId;
    /**
     * 字段属性名称
     */
    private  String   fieldName;
    /**
     * 操作符
     */
    private  Long  operatorId;
    /**
     *
     */
    private  String   operatorValue;
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

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
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

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOperatorValue() {
        return operatorValue;
    }

    public void setOperatorValue(String operatorValue) {
        this.operatorValue = operatorValue;
    }

    public Long getConditionWhenId() {
        return conditionWhenId;
    }

    public void setConditionWhenId(Long conditionWhenId) {
        this.conditionWhenId = conditionWhenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConditionWhenItemDto)) return false;
        ConditionWhenItemDto that = (ConditionWhenItemDto) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
