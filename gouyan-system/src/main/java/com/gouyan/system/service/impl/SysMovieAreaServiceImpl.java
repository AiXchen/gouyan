package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gouyan.system.domin.SysMovieArea;
import com.gouyan.system.mapper.SysMovieAreaMapper;
import com.gouyan.system.service.SysMovieAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 15:16
 */
@Service
public class SysMovieAreaServiceImpl extends ServiceImpl<SysMovieAreaMapper,SysMovieArea> implements SysMovieAreaService {
    @Autowired
    private SysMovieAreaMapper sysMovieAreaMapper;

    @Override
    public List<SysMovieArea> findAll() {
        return baseMapper.selectList(null);
//        return sysMovieAreaMapper.findAll();
    }

    @Override
    public SysMovieArea findById(Long id) {
        return baseMapper.selectById(id);
//        return sysMovieAreaMapper.findById(id);
    }

    @Override
    public int add(SysMovieArea sysMovieArea) {
        return baseMapper.insert(sysMovieArea);
//        return sysMovieAreaMapper.add(sysMovieArea);
    }

    @Override
    public int update(SysMovieArea sysMovieArea) {
        return baseMapper.updateById(sysMovieArea);
//        return sysMovieAreaMapper.update(sysMovieArea);
    }

    @Override
    public int delete(Long[] ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
//        int rows = 0;
//        for (Long id : ids) {
//            rows += sysMovieAreaMapper.delete(id);
//        }
//        return rows;
    }
}
