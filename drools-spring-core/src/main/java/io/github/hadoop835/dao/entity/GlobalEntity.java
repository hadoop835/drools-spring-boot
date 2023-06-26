package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;

/**
 * 全局变量
 * @author chenzhh
 */
@Table(value = "dr_global")
public class GlobalEntity extends BaseEntity {
    /**
     * 名称
     */
    private  String  name;
    /**
     * 全路径类名称
     */
    private  String  clazz;
    /**
     * 变量名称
     */
    private  String   var;
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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public Long getRulesId() {
        return rulesId;
    }

    public void setRulesId(Long rulesId) {
        this.rulesId = rulesId;
    }
}
