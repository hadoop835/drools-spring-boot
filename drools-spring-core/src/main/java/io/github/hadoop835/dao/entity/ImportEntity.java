package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Table;

/**
 * 导入类
 * @author chenzhh
 */
@Table(value = "dr_import")
public class ImportEntity extends BaseEntity {
    /**
     * 名称
     */
   private  String  name;
    /**
     * 全路径类名称
     */
   private  String  clazz;
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

    public Long getRulesId() {
        return rulesId;
    }

    public void setRulesId(Long rulesId) {
        this.rulesId = rulesId;
    }
}
