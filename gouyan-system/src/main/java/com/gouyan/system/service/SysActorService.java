package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysActor;

import java.util.List;

/**
 * @author lxd
 * @create 2020-11-23 15:36
 */
public interface SysActorService extends IService<SysActor> {
    List<SysActor> findAll(SysActor sysActor);

    SysActor findById(Long id);

    int add(SysActor sysActor);

    int update(SysActor sysActor);

    int delete(Long[] ids);

    SysActor findActorById(Long id);
}
