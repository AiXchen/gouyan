package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.LoginUser;
import com.gouyan.system.domin.SysMovie;
import com.gouyan.system.domin.SysUser;
import com.gouyan.system.domin.vo.SysUserVo;
import com.gouyan.system.mapper.SysUserMapper;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/23 11:10
 */
public interface SysUserService extends IService<SysUser>{
    List<SysUser> findAll(SysUser sysUser);

    SysUser findById(Long id);

    SysUser findByName(String userName);

    int add(SysUser sysUser);

    int update(SysUser sysUser);

    int delete(Long[] ids);

    LoginUser login(SysUserVo sysUserVo);

    LoginUser findLoginUser(SysUserVo sysUserVo);

    boolean isUserNameUnique(String userName, Long userId);
}
