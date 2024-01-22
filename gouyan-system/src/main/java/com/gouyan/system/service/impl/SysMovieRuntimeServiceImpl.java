package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.system.domin.SysMovieRuntime;
import com.gouyan.system.mapper.SysMovieRuntimeMapper;
import com.gouyan.system.service.SysMovieRuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 17:13
 */
@Service
public class SysMovieRuntimeServiceImpl extends ServiceImpl<SysMovieRuntimeMapper,SysMovieRuntime> implements SysMovieRuntimeService {

    @Autowired
    private SysMovieRuntimeMapper sysMovieRuntimeMapper;

    @Override
    public List<SysMovieRuntime> findAll() {
        return baseMapper.selectList(null);
//        return sysMovieRuntimeMapper.findAll();
    }

    @Override
    public SysMovieRuntime findById(Long id) {
//        return baseMapper.selectOne(new MPJLambdaWrapper<SysMovieRuntime>()
//                .eq(SysMovieRuntime::getMovieRuntimeId, id));
        return baseMapper.selectById(id);
//        return sysMovieRuntimeMapper.findById(id);
    }

    @Override
    public int add(SysMovieRuntime sysMovieRuntime) {
        return baseMapper.insert(sysMovieRuntime);
//        return sysMovieRuntimeMapper.add(sysMovieRuntime);
    }

    @Override
    public int update(SysMovieRuntime sysMovieRuntime) {
        return baseMapper.updateById(sysMovieRuntime);
//        return sysMovieRuntimeMapper.update(sysMovieRuntime);
    }

    @Override
    public int delete(Long[] ids) {

        return baseMapper.deleteBatchIds(Arrays.asList(ids));
//        int rows = 0;
//        for(Long id : ids){
//            rows += sysMovieRuntimeMapper.delete(id);
//        }
//        return rows;
    }
}
