package com.gouyan.system.service;

import com.gouyan.system.domin.SysMovie;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-22 15:56
 */
public interface SysMovieService {

    List<SysMovie> findAll(SysMovie sysMovie);

    SysMovie findById(Long id);

    int add(SysMovie sysMovie);

    int update(SysMovie sysMovie);

    int delete(Long[] ids);

}
