package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gouyan.system.domin.SysCinemaArea;
import com.gouyan.system.mapper.SysCinemaAreaMapper;
import com.gouyan.system.service.SysCinemaAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-20 09:19
 */
@Service
public class SysCinemaAreaServiceImpl extends ServiceImpl<SysCinemaAreaMapper,SysCinemaArea> implements SysCinemaAreaService {

    @Autowired
    private SysCinemaAreaMapper sysCinemaAreaMapper;

    @Override
    public List<SysCinemaArea> findAll() {
        return baseMapper.selectList(null);
//        return sysCinemaAreaMapper.findAll();
    }

    @Override
    public SysCinemaArea findById(Long id) {
        return baseMapper.selectById(id);
//        return sysCinemaAreaMapper.findById(id);
    }

    @Override
    public int add(SysCinemaArea sysCinemaArea) {
        return baseMapper.insert(sysCinemaArea);
//        return sysCinemaAreaMapper.add(sysCinemaArea);
    }

    @Override
    public int update(SysCinemaArea sysCinemaArea) {
        return baseMapper.updateById(sysCinemaArea);
//        return sysCinemaAreaMapper.update(sysCinemaArea);
    }

    @Override
    public int delete(Long[] ids) {
        int i = baseMapper.deleteBatchIds(Arrays.asList(ids));
        return i;

    }
//        int rows = 0;
//        for(Long id : ids){
//            rows += sysCinemaAreaMapper.delete(id);
//        }
//        return rows;
//    }
}
