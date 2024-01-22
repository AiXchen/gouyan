package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysHall;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 14:49
 */
public interface SysHallMapper extends MPJBaseMapper<SysHall> {
    List<SysHall> findAll(SysHall sysHall);

    SysHall findByCinemaIdAndHallId(SysHall sysHall);

    int add(SysHall sysHall);

    int update(SysHall sysHall);

    int delete(SysHall sysHall);
}
