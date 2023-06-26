package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;
import io.github.hadoop835.dto.ConditionDto;

/**
 * 规则条件
 * @author
 */
@Table(value = "dr_condition")
public class ConditionEntity extends BaseEntity {
    /**
     * 名称
     */
    private  String name;
    /**
     * 执行动作
     */
    private  String  action;
    /**
     * 规则
     */
    private Long    rulesId;



    public ConditionDto toConditionDto(){
        ConditionDto conditionDto = new ConditionDto();
        conditionDto.setId(getId());
        conditionDto.setName(getName());
        conditionDto.setAction(getAction());
        conditionDto.setRulesId(getRulesId());
        return conditionDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getRulesId() {
        return rulesId;
    }

    public void setRulesId(Long rulesId) {
        this.rulesId = rulesId;
    }
}
