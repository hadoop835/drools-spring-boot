package io.github.hadoop835.dto;

import java.util.Objects;

/**
 * @author chenzhh
 */
public class ConditionAttrDto extends BaseDto {
    /**
     * 名称
     */
    private  String  name;
    /**
     * 属性名称
     */
    private  String  attrName;
    /**
     * 属性值
     */
    private  String   attrValue;
    /**
     * 条件属性
     */
    private  Long    conditionId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public Long getConditionId() {
        return conditionId;
    }

    public void setConditionId(Long conditionId) {
        this.conditionId = conditionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConditionAttrDto)) return false;
        ConditionAttrDto that = (ConditionAttrDto) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
