package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;
import io.github.hadoop835.dto.AttributeDto;
import io.github.hadoop835.dto.AttributeItemDto;

/**
 * 维护属性值
 * @author chenzhh
 */
@Table(value = "dr_attribute_item")
public class AttributeItemEntiry extends BaseEntity {
    /**
     * 名称
     */
    private String   remark;
    /**
     * 值
     */
    private  String  value;
    /**
     * 关联主表
     */
    private Long   attributeId;


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    /**
     *
     * @param attributeItemDto
     * @return
     */
    public AttributeItemEntiry  toAttributeItemEntiry(AttributeItemDto attributeItemDto){
          setValue(attributeItemDto.getValue());
          setAttributeId(attributeItemDto.getId());
          setRemark(attributeItemDto.getRemark());
          return this;
    }
}
