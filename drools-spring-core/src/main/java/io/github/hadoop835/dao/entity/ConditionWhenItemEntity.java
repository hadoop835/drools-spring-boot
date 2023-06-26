package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;
import io.github.hadoop835.dto.ConditionWhenItemDto;
import org.checkerframework.checker.units.qual.C;

/**
 * 规矩条件
 * @author chenzhh
 */
@Table(value ="dr_condition_when_item" )
public class ConditionWhenItemEntity extends BaseEntity {
    /**
     * 字段主键
     */
   private  Long   fieldId;
    /**
     * 操作符
     */
   private  Long  operatorId;
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

    /**
     *
     * @return
     */
    public ConditionWhenItemDto toConditionWhenItemDto(){
        ConditionWhenItemDto conditionWhenItemDto = new ConditionWhenItemDto();
        conditionWhenItemDto.setFieldId(getFieldId());
        conditionWhenItemDto.setOperatorId(getOperatorId());
        conditionWhenItemDto.setSymbol(getSymbol());
        conditionWhenItemDto.setValue(getValue());
        conditionWhenItemDto.setId(getId());
        conditionWhenItemDto.setConditionWhenId(getConditionWhenId());
        return conditionWhenItemDto;
    }
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

    public Long getConditionWhenId() {
        return conditionWhenId;
    }

    public void setConditionWhenId(Long conditionWhenId) {
        this.conditionWhenId = conditionWhenId;
    }
}
