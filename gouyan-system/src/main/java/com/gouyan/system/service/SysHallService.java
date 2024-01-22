package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysHall;
import com.gouyan.system.domin.SysHallCategory;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 14:49
 */
public interface SysHallService extends IService<SysHall> {
    List<SysHall> findAll(SysHall sysHall);

    SysHall findByCinemaIdAndHallId(SysHall sysHall);

    int add(SysHall sysHall);

    int update(SysHall sysHall);

    int delete(SysHall[] sysHall);
}
