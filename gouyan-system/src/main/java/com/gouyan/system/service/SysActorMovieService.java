package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysActor;
import com.gouyan.system.domin.SysActorMovie;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-27 10:25
 */

public interface SysActorMovieService extends IService<SysActorMovie> {
    List<SysActorMovie> findAll(SysActorMovie sysActorMovie);

    int add(SysActorMovie sysActorMovie);

    int delete(SysActorMovie sysActorMovie);
}
