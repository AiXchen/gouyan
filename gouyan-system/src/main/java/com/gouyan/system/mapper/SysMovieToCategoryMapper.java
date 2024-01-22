package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysMovieToCategory;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 17:24
 */
public interface SysMovieToCategoryMapper extends MPJBaseMapper<SysMovieToCategory> {

    List<SysMovieToCategory> findAll(SysMovieToCategory sysMovieToCategory);

    int add(SysMovieToCategory sysMovieToCategory);

    int delete(SysMovieToCategory sysMovieToCategory);

}
