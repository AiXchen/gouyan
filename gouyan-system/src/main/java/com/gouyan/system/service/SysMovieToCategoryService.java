package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysMovie;
import com.gouyan.system.domin.SysMovieToCategory;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 17:24
 */
public interface SysMovieToCategoryService extends IService<SysMovieToCategory> {

    List<SysMovieToCategory> findAll(SysMovieToCategory sysMovieToCategory);

    int add(SysMovieToCategory sysMovieToCategory);

    int delete(SysMovieToCategory sysMovieToCategory);

}
