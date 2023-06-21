package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.io.Serializable;

/**
 * 规则资源文件表
 * @author Administrator
 */
@Table(value = "dr_rules")
public class RulesEntity extends BaseEntity implements Serializable {

    private String instanceId;
    private String name;
    private byte[] rules;
    @Column(onUpdateValue = "version + 1")
    private Integer version;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getRules() {
        return rules;
    }

    public void setRules(byte[] rules) {
        this.rules = rules;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
