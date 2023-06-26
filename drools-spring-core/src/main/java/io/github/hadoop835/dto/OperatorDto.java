package io.github.hadoop835.dto;

public class OperatorDto extends  BaseDto{
    /**
     * 名称
     */
    private  String  name;
    /**
     * 操作符
     */
    private  String  value;
    /**
     * 排序
     */
    private Integer  sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
