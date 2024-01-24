package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysCinemaArea;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/24 17:39
 */
public interface SysCinemaAreaMapper extends MPJBaseMapper<SysCinemaArea> {

    /**
     * 查询所有
     * @return
     */
    List<SysCinemaArea> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysCinemaArea findById(Long id);

    /**
     * 添加演员角色
     * @param sysCinemaArea
     * @return 影响行数
     */
    int add(SysCinemaArea sysCinemaArea);

    /**
     * 修改演员角色
     * @param sysCinemaArea
     */
    int update(SysCinemaArea sysCinemaArea);

    /**
     * 删除指定id的演员角色
     * @param id
     */
    int delete(Long id);

}
