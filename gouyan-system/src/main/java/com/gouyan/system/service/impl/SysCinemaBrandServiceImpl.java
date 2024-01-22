package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gouyan.system.domin.SysCinemaBrand;
import com.gouyan.system.mapper.SysCinemaBrandMapper;
import com.gouyan.system.service.SysCinemaBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-12-03 16:59
 */
@Service
public class SysCinemaBrandServiceImpl extends ServiceImpl<SysCinemaBrandMapper,SysCinemaBrand> implements SysCinemaBrandService {

    @Autowired
    private SysCinemaBrandMapper sysCinemaBrandMapper;

    @Override
    public List<SysCinemaBrand> findAll() {
        return baseMapper.selectList(null);
//        return sysCinemaBrandMapper.findAll();
    }

    @Override
    public SysCinemaBrand findById(Long id) {
        return baseMapper.selectById(id);
//        return sysCinemaBrandMapper.findById(id);
    }

    @Override
    public int add(SysCinemaBrand sysCinemaBrand) {
        return baseMapper.insert(sysCinemaBrand);
//        return sysCinemaBrandMapper.add(sysCinemaBrand);
    }

    @Override
    public int update(SysCinemaBrand sysCinemaBrand) {
        return baseMapper.updateById(sysCinemaBrand);
//        return sysCinemaBrandMapper.update(sysCinemaBrand);
    }

    @Override
    public int delete(Long[] ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
//        int rows = 0;
//        for(Long id : ids){
//            rows += sysCinemaBrandMapper.delete(id);
//        }
//        return rows;
    }
}
