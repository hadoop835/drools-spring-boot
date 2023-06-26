package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;
import io.github.hadoop835.dto.OperatorDto;

/**
 * 基础数据操作符维护
 * @author chenzhh
 */
@Table(value = "dr_operator")
public class OperatorEntity extends BaseEntity {
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

    /**
     *
     * @return
     */
    public OperatorDto toOperatorDto(){
        OperatorDto operatorDto = new OperatorDto();
        operatorDto.setId(getId());
        operatorDto.setName(getName());
        operatorDto.setValue(getValue());
        operatorDto.setSort(getSort());
        return operatorDto;
    }
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
