package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysMovieAge;
import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 15:12
 */
public interface SysMovieAgeMapper extends MPJBaseMapper<SysMovieAge> {

    /**
     * 查询所有
     * @return
     */
    List<SysMovieAge> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysMovieAge findById(Long id);

    /**
     * 添加电影年代
     * @param sysMovieAge
     * @return 影响行数
     */
    int add(SysMovieAge sysMovieAge);

    /**
     * 修改电影年代
     * @param sysMovieAge
     */
    int update(SysMovieAge sysMovieAge);

    /**
     * 删除指定id的电影年代
     * @param id
     */
    int delete(Long id);
}
