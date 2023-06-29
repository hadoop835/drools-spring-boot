package io.github.hadoop835.dto;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenzhh
 */
public class AttributeDto extends BaseDto {
    private String  name;
    private String  type;
    private String  remark;
    private List<AttributeItemDto> attributeItemDtos = Lists.newArrayList();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<AttributeItemDto> getAttributeItemDtos() {
        return attributeItemDtos;
    }

    public void setAttributeItemDtos(List<AttributeItemDto> attributeItemDtos) {
        this.attributeItemDtos = attributeItemDtos;
    }

    /**
     *
     * @param attributeItemDto
     */
    public    void addAttributeItemDto(AttributeItemDto attributeItemDto){
             if(attributeItemDtos.contains(attributeItemDto)){
                 attributeItemDtos.add(attributeItemDto);
             }
    }

}
