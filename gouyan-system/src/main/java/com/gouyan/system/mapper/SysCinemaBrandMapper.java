package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysCinemaBrand;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/24 17:39
 */
public interface SysCinemaBrandMapper extends MPJBaseMapper<SysCinemaBrand> {
    
    List<SysCinemaBrand> findAll();
    
    SysCinemaBrand findById(Long id);
    
    int add(SysCinemaBrand sysCinemaBrand);
    
    int update(SysCinemaBrand sysCinemaBrand);

    int delete(Long id);
}
