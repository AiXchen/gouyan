package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.system.domin.SysMovieToCategory;
import com.gouyan.system.mapper.SysMovieToCategoryMapper;
import com.gouyan.system.service.SysMovieToCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Aixchen
 * @date 2024/1/22 17:24
 */
@Service
public class SysMovieToCategoryServiceImpl extends ServiceImpl<SysMovieToCategoryMapper,SysMovieToCategory> implements SysMovieToCategoryService {

    @Autowired
    private SysMovieToCategoryMapper sysMovieToCategoryMapper;

    @Override
    public List<SysMovieToCategory> findAll(SysMovieToCategory sysMovieToCategory) {
        MPJLambdaWrapper<SysMovieToCategory> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysMovieToCategory.class);
        if(Optional.ofNullable(sysMovieToCategory.getMovieId()).isPresent()){
            wrapper.eq(SysMovieToCategory::getMovieId, sysMovieToCategory.getMovieId() );
        }
        if(Optional.ofNullable(sysMovieToCategory.getMovieCategoryId()).isPresent()){
            wrapper.eq(SysMovieToCategory::getMovieCategoryId, sysMovieToCategory.getMovieCategoryId() );
        }
        return baseMapper.selectList(wrapper);
//        return sysMovieToCategoryMapper.findAll(sysMovieToCategory);
    }

    @Override
    public int add(SysMovieToCategory sysMovieToCategory) {
        return baseMapper.insert(sysMovieToCategory);
//        return sysMovieToCategoryMapper.add(sysMovieToCategory);
    }

    @Override
    public int delete(SysMovieToCategory sysMovieToCategory) {
        return baseMapper.delete(sysMovieToCategory);
//        return sysMovieToCategoryMapper.delete(sysMovieToCategory);
    }
}
