package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysCinema;
import com.gouyan.system.domin.vo.SysCinemaVo;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/24 15:29
 */
public interface SysCinemaMapper extends MPJBaseMapper<SysCinema> {

    List<SysCinema> findAll(SysCinemaVo sysCinemaVo);

    SysCinema findById(Long id);

    int add(SysCinema sysCinema);

    int update(SysCinema sysCinema);

    int delete(Long id);

    //前台展示单个影院信息，返回包含影院、上映中的所有电影信息
    SysCinema findCinemaById(Long id);

}
