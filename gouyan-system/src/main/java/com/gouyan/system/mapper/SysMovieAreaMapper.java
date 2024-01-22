package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysMovieAge;
import com.gouyan.system.domin.SysMovieArea;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 15:15
 */
public interface SysMovieAreaMapper extends MPJBaseMapper<SysMovieArea> {
    /**
     * 查询所有电影区域
     * @return
     */
    List<SysMovieArea> findAll();

    /**
     * 根据id查询电影区域
     * @param id
     * @return
     */
    SysMovieArea findById(Long id);

    /**
     * 添加电影区域信息
     * @param sysMovieArea
     * @return
     */
    int add(SysMovieArea sysMovieArea);


    /**
     * 更新电影区域信息
     * @param sysMovieArea
     * @return
     */
    int update(SysMovieArea sysMovieArea);

    /**
     * 删除指定id的电影区域
     * @param id
     */
    int delete(Long id);
}
