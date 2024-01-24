package com.gouyan.system.service;

import com.gouyan.system.domin.SysUserHobby;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/24 17:40
 */
public interface SysUserHobbyService {

    List<SysUserHobby> findAll();

    SysUserHobby findById(Long id);

    int add(SysUserHobby sysUserHobby);

    int update(SysUserHobby sysUserHobby);

    int delete(Long[] ids);

}
