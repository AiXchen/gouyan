package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysActorMovie;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-27 10:13
 */
public interface SysActorMovieMapper extends MPJBaseMapper<SysActorMovie> {
    List<SysActorMovie> findAll(SysActorMovie sysActorMovie);

    int add(SysActorMovie sysActorMovie);

    int delete(SysActorMovie sysActorMovie);
}
