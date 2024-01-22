package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.system.domin.SysActorRole;
import com.gouyan.system.mapper.SysActorRoleMapper;
import com.gouyan.system.service.SysActorRoleService;
import org.springframework.beans.BeanUtils;
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
//        MPJLambdaWrapper<SysActorRole> wrapper = new MPJLambdaWrapper<>();
//        wrapper.select(SysActorRole::getActorRoleId,SysActorRole::getActorRoleName);
//        return baseMapper.selectList(wrapper);
        return baseMapper.selectList(null);
//        return sysActorRoleMapper.findAll();
    }

    @Override
    public SysActorRole findById(Long id) {
//        MPJLambdaWrapper<SysActorRole> wrapper = new MPJLambdaWrapper<>();
//        wrapper.select(SysActorRole::getActorRoleName,SysActorRole::getActorRoleId)
//                .eq(SysActorRole::getActorRoleId,id );
//        return baseMapper.selectOne(wrapper);

        return baseMapper.selectById(id);
//        return sysActorRoleMapper.findById(id);
    }

    @Override
    public int add(SysActorRole sysActorRole) {
        return sysActorRoleMapper.add(sysActorRole);
    }

    @Override
    public int update(SysActorRole sysActorRole) {
//        SysActorRole actorRole = findById(sysActorRole.getActorRoleId());
//        actorRole.setActorRoleName(sysActorRole.getActorRoleName());
//        return baseMapper.update(actorRole);
        return sysActorRoleMapper.update(sysActorRole);
    }

    @Override
    public int delete(Long[] ids) {
        MPJLambdaWrapper<SysActorRole> wrapper = new MPJLambdaWrapper<>();
//        wrapper.in(SysActorRole::getActorRoleId,Arrays.asList(ids));
//        return baseMapper.delete(wrapper);
        return baseMapper.deleteBatchIds(Arrays.stream(ids).collect(Collectors.toList()));
//        int rows = 0;
//        for(Long id : ids){
//            rows += sysActorRoleMapper.delete(id);
//        }
//        return rows;
    }
}
