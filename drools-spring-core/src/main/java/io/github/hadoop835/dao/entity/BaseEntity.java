package io.github.hadoop835.dao.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;

import java.time.LocalDateTime;

/**
 * @author Administrator
 */
public abstract class BaseEntity {
    @Id(keyType = KeyType.Generator,value = "snowFlakeId")
    private Long   id;
    @Column(onInsertValue = "now()")
    private LocalDateTime createTime;
    private String   createBy;
    @Column(onUpdateValue = "now()",onInsertValue = "now()")
    private LocalDateTime updateTime;
    private String   updateBy;
    @Column(onUpdateValue = "version + 1")
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
