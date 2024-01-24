package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysBill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/24 15:02
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
