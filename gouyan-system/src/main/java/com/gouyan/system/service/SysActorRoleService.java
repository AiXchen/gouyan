package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysActorRole;
import com.gouyan.system.domin.SysMovieAge;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/24 17:39
 */
public interface SysActorRoleService extends IService<SysActorRole> {
    List<SysActorRole> findAll();

    SysActorRole findById(Long id);

    int add(SysActorRole sysActorRole);

    int update(SysActorRole sysActorRole);

    int delete(Long[] ids);
}
