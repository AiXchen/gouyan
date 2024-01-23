package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.system.domin.SysRole;
import com.gouyan.system.domin.SysRoleResource;
import com.gouyan.system.mapper.SysRoleMapper;
import com.gouyan.system.mapper.SysRoleResourceMapper;
import com.gouyan.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/23 10:41
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;

    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.findAll();
    }

    @Override
    public SysRole findById(Long id) {
        return baseMapper.selectById(id);
//        return sysRoleMapper.findById(id);
    }

    @Override
    public int add(SysRole sysRole) {
        return baseMapper.insert(sysRole);
//        return sysRoleMapper.add(sysRole);
    }

    @Override
    public int update(SysRole sysRole) {
        return baseMapper.updateById(sysRole);
//        return sysRoleMapper.update(sysRole);
    }

    @Override
    public int delete(Long[] ids) {
//        int rows = 0;
//        for(Long id : ids){
//            rows += sysRoleMapper.delete(id);
//        }
//        return rows;
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int allotRight(Long roleId, Long[] keys) {
//        int rows = 0;
//        HashSet<Long> originResources = new HashSet<>(sysRoleMapper.findAllRights(roleId));
//
//        for(Long id : keys){
//            if(originResources.contains(id)){
//                originResources.remove(id);
//            }else{
//                rows += sysRoleMapper.addRight(roleId, id);
//            }
//        }
//        for(Long id : originResources){
//            rows += sysRoleMapper.deleteRight(roleId, id);
//        }
//        return rows;

        sysRoleResourceMapper.delete(new MPJLambdaWrapper<SysRoleResource>()
                .eq(SysRoleResource::getRoleId, roleId ));
        if(keys.length != 0){
            for(Long key : keys){
                sysRoleResourceMapper.insert(SysRoleResource.builder().roleId(roleId).resourceId(key).build());
            }
        }
        return keys.length == 0 ?  1:keys.length;
    }
}
