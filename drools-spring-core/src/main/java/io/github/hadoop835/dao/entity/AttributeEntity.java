package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;

/**
 * 属性
 * @author chenzhh
 */
@Table(value = "dr_attribute")
public class AttributeEntity extends BaseEntity {
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
}
