package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysMovieArea;
import com.gouyan.system.domin.SysMovieCategory;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 15:19
 */
public interface SysMovieCategoryService extends IService<SysMovieCategory> {
    List<SysMovieCategory> findAll();

    SysMovieCategory findById(Long id);

    int add(SysMovieCategory sysMovieCategory);

    int update(SysMovieCategory sysMovieCategory);

    int delete(Long[] ids);

    /**
     * 根据电影id查询所属的全部类别
     * @param id
     * @return
     */
    List<SysMovieCategory> findByMovieId(Long id);
}
