package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gouyan.system.domin.SysMovieCategory;
import com.gouyan.system.mapper.SysMovieCategoryMapper;
import com.gouyan.system.service.SysMovieCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.swing.BakedArrayList;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 15:19
 */
@Service
public class SysMovieCategoryServiceImpl extends ServiceImpl<SysMovieCategoryMapper,SysMovieCategory> implements SysMovieCategoryService {

    @Autowired
    private SysMovieCategoryMapper sysMovieCategoryMapper;

    @Override
    public List<SysMovieCategory> findAll() {
        return baseMapper.selectList(null);
//        return sysMovieCategoryMapper.findAll();
    }

    @Override
    public SysMovieCategory findById(Long id) {
        return baseMapper.selectById(id);
//        return sysMovieCategoryMapper.findById(id);
    }

    @Override
    public int add(SysMovieCategory sysMovieCategory) {
        return baseMapper.insert(sysMovieCategory);
//        return sysMovieCategoryMapper.add(sysMovieCategory);
    }

    @Override
    public int update(SysMovieCategory sysMovieCategory) {
        return baseMapper.updateById(sysMovieCategory);
//        return sysMovieCategoryMapper.update(sysMovieCategory);
    }

    @Override
    public int delete(Long[] ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
//        int rows = 0;
//        for (Long id : ids) {
//            rows += sysMovieCategoryMapper.delete(id);
//        }
//        return rows;
    }
}
