package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;
import io.github.hadoop835.dto.AttributeDto;

/**
 * 维护属性
 * @author Administrator
 */
@Table(value = "dr_attribute")
public class AttributeEntiry extends BaseEntity {
    /**
     * 名称
     */
    private  String  name;
    /**
     * 类型
     */
    private  String  type;
    /**
     * 备注
     */
    private  String  remark;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public AttributeDto  toAttributeDto(){
        AttributeDto attributeDto = new AttributeDto();
        attributeDto.setId(getId());
        attributeDto.setName(getName());
        attributeDto.setRemark(getRemark());
        attributeDto.setType(getType());
        return attributeDto;
    }

    /**
     *
     * @param attributeDto
     * @return
     */
    public AttributeEntiry  toAttributeEntiry(AttributeDto attributeDto){
          setType(attributeDto.getType());
          setRemark(attributeDto.getRemark());
          setName(attributeDto.getName());
          setId(getId());
        return this;
    }
}
