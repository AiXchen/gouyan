package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gouyan.system.domin.SysActorRole;
import com.gouyan.system.mapper.SysActorRoleMapper;
import com.gouyan.system.service.SysActorRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-19 22:53
 */
@Service
public class SysActorRoleServiceImpl extends ServiceImpl<SysActorRoleMapper,SysActorRole> implements SysActorRoleService {

    @Autowired
    private SysActorRoleMapper sysActorRoleMapper;

    @Override
    public List<SysActorRole> findAll() {
        return baseMapper.selectList(null);
//        return sysActorRoleMapper.findAll();
    }

    @Override
    public SysActorRole findById(Long id) {
        return baseMapper.selectById(id);
//        return sysActorRoleMapper.findById(id);
    }

    @Override
    public int add(SysActorRole sysActorRole) {
        return sysActorRoleMapper.add(sysActorRole);
    }

    @Override
    public int update(SysActorRole sysActorRole) {
        return baseMapper.updateById(sysActorRole);
//        return sysActorRoleMapper.update(sysActorRole);
    }

    @Override
    public int delete(Long[] ids) {
        return baseMapper.deleteBatchIds(Arrays.stream(ids).collect(Collectors.toList()));
//        int rows = 0;
//        for(Long id : ids){
//            rows += sysActorRoleMapper.delete(id);
//        }
//        return rows;
    }
}
