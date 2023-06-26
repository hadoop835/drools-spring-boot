package io.github.hadoop835.service;

import io.github.hadoop835.dto.OperatorDto;

import java.util.List;

/**
 * 操作符业务逻辑
 * @author chenzhh
 */
public interface OperatorService {
    /**
     * 查询全部操作符
     * @return
     */
    List<OperatorDto> listAll();

    /**
     *
     * @param operatorDtos
     * @param operatorId
     * @return
     */
    OperatorDto  getOperatorById(List<OperatorDto> operatorDtos,Long operatorId);
}
