package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gouyan.system.domin.SysMovieAge;
import com.gouyan.system.mapper.SysMovieAgeMapper;
import com.gouyan.system.service.SysMovieAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.prefs.BackingStoreException;

/**
 * @author Aixchen
 * @date 2024/1/22 15:12
 */
@Service
public class SysMovieAgeServiceImpl extends ServiceImpl<SysMovieAgeMapper,SysMovieAge> implements SysMovieAgeService {

    @Autowired
    private SysMovieAgeMapper sysMovieAgeMapper;

    @Override
    public List<SysMovieAge> findAll() {
        return baseMapper.selectList(null);
//        return sysMovieAgeMapper.findAll();
    }

    @Override
    public SysMovieAge findById(Long id) {
        return baseMapper.selectById(id);
//        return sysMovieAgeMapper.findById(id);
    }

    @Override
    public int add(SysMovieAge sysMovieAge) {
        return baseMapper.insert(sysMovieAge);
//        return sysMovieAgeMapper.add(sysMovieAge);
    }

    @Override
    public int update(SysMovieAge sysMovieAge) {
        return baseMapper.updateById(sysMovieAge);
//        return sysMovieAgeMapper.update(sysMovieAge);
    }

    @Override
    public int delete(Long[] ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
//        int rows = 0;
//        for(Long id : ids)
//            rows += sysMovieAgeMapper.delete(id);
//        return rows;
    }
}
