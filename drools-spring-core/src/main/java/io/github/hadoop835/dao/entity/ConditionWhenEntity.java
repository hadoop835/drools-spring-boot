package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;

/**
 * 条件
 * @author chenzhh
 */
@Table(value = "dr_condition_when")
public class ConditionWhenEntity extends BaseEntity {
    /**
     * 变量名称
     */
    private  String  varName;
    /**
     * 变量值
     */
    private  String  varValue;
    /**
     *  连接词 and  or
     */
    private  String   symbol;


    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public String getVarValue() {
        return varValue;
    }

    public void setVarValue(String varValue) {
        this.varValue = varValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
