package io.github.hadoop835.service;

import io.github.hadoop835.dao.entity.RulesEntity;

import java.io.InputStream;

/**
 *
 * @author Administrator
 */
public interface RulesService {
    /**
     *
     * @param instanceId 实例Id
     * @return
     */
    byte[] getRules(String  instanceId);

    /**
     *
     * @param instanceId 实例Id
     * @return
     */
    RulesEntity getRulesEntity(String  instanceId);

    /**
     * 保存规则文件
     * @param rulesEntity
     */
    void save(RulesEntity rulesEntity);


    /**
     * 保存规则文件
     * @param rulesEntity
     */
    boolean update(RulesEntity rulesEntity);
}
