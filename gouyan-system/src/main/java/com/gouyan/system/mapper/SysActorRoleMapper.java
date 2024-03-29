package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysActorRole;
import com.gouyan.system.domin.SysMovieAge;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/24 17:39
 */
public interface SysActorRoleMapper extends MPJBaseMapper<SysActorRole> {

    /**
     * 查询所有
     * @return
     */
    List<SysActorRole> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysActorRole findById(Long id);

    /**
     * 添加演员角色
     * @param sysActorRole
     * @return 影响行数
     */
    int add(SysActorRole sysActorRole);

    /**
     * 修改演员角色
     * @param sysActorRole
     */
    int update(SysActorRole sysActorRole);

    /**
     * 删除指定id的演员角色
     * @param id
     */
    int delete(Long id);

}
