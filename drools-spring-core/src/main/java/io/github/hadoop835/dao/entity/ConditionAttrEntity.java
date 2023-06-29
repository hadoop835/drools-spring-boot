package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;
import io.github.hadoop835.dto.ConditionAttrDto;

/**
 * 属性
 * @author chenzhh
 */
@Table(value = "dr_condition_attr")
public class ConditionAttrEntity extends BaseEntity {
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


    public ConditionAttrEntity toAttributeEntity(ConditionAttrDto attributeDto){
              setId(attributeDto.getId());
              setAttrName(attributeDto.getAttrName());
              setAttrValue(attributeDto.getAttrValue());
              setName(attributeDto.getName());
              setConditionId(attributeDto.getConditionId());
              setVersion(1);
        return this;
    }

    /**
     *
     * @return
     */
    public ConditionAttrDto toAttributeDto(){
        ConditionAttrDto attributeDto = new ConditionAttrDto();
        attributeDto.setId(getId());
        attributeDto.setAttrName(getAttrName());
        attributeDto.setAttrValue(getAttrValue());
        attributeDto.setName(getName());
        attributeDto.setConditionId(getConditionId());
        return attributeDto;
    }

}
