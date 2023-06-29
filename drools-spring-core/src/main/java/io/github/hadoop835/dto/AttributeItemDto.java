package io.github.hadoop835.dto;

import java.util.Objects;

/**
 * 属性值
 * @author Administrator
 */
public class AttributeItemDto extends BaseDto {
    /**
     * 属性值
     */
    private String value;
    /**
     * 属性备注
     */
    private String remark;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttributeItemDto)) return false;
        AttributeItemDto that = (AttributeItemDto) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }


}
