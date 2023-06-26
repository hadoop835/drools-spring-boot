package io.github.hadoop835.dto;

/**
 * @author Administrator
 */
public class FieldDto extends BaseDto{
    /**
     * 字段中文名称
     */
    private  String  name;
    /**
     * 字段名称，中文
     */
    private  String  fieldName;
    /**
     * 字段类型
     */
    private  String   fieldType;
    /**
     * 规则主键
     */
    private  Long    rulesId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Long getRulesId() {
        return rulesId;
    }

    public void setRulesId(Long rulesId) {
        this.rulesId = rulesId;
    }
}
