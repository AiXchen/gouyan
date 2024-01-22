package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysMovieRuntime;
import com.gouyan.system.domin.SysUserHobby;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 17:13
 */
public interface SysMovieRuntimeService extends IService<SysMovieRuntime> {

    List<SysMovieRuntime> findAll();

    SysMovieRuntime findById(Long id);

    int add(SysMovieRuntime sysMovieRuntime);

    int update(SysMovieRuntime sysMovieRuntime);

    int delete(Long[] ids);

}
