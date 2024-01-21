package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysBill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-30 14:01
 */
@Mapper
public interface SysBillMapper extends MPJBaseMapper<SysBill> {

    List<SysBill> findAll(SysBill sysBill);

    SysBill findById(Long id);

    int add(SysBill sysBill);

    int update(SysBill sysBill);

    int delete(Long id);

    Double todayBoxOffice();
    
}
