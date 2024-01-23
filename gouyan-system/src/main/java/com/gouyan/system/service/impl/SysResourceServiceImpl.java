package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.system.domin.SysResource;
import com.gouyan.system.mapper.SysResourceMapper;
import com.gouyan.system.service.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/23 9:10
 */
@Slf4j
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper,SysResource> implements SysResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Override
    public List<SysResource> findAll() {
        List<SysResource> resourceList = baseMapper.selectList(null);
        for(SysResource s : resourceList){
            findParent(s);
        }
        return resourceList;
//        return sysResourceMapper.findAll();
    }

    private void findParent(SysResource s) {
        Long parentId = s.getParentId();
        SysResource parent = baseMapper.selectOne(new MPJLambdaWrapper<SysResource>()
                .eq(SysResource::getId, parentId));
        if(parent != null){
            s.setParent(parent);
        }else {
            s.setParent(new SysResource());
        }
    }

    @Override
    public List<SysResource> findWithChildren() {
        List<SysResource> resourceList = baseMapper.selectList(null);
        for(SysResource s : resourceList){
            findChildren(s);
        }
        return resourceList;
//        return sysResourceMapper.findWithChildren();
    }

    private void findChildren(SysResource s) {
        Long id = s.getId();
        List<SysResource> childrenList = baseMapper.selectList(new MPJLambdaWrapper<SysResource>()
                .eq(SysResource::getParentId, id));
        if(CollectionUtils.isEmpty(childrenList)){
            s.setChildren(Collections.emptyList());
        }else{
            s.setChildren(childrenList);
        }
    }

    @Override
    public List<SysResource> findAllWithAllChildren() {
        List<SysResource> resourceList = baseMapper.selectList(null);
        for(SysResource s : resourceList){
            findAllChildren(s);
        }
        return resourceList;
//        return sysResourceMapper.findAllWithAllChildren();
    }

    private void findAllChildren(SysResource s) {
        Long id = s.getId();
        List<SysResource> childrenList = baseMapper.selectList(new MPJLambdaWrapper<SysResource>()
                .eq(SysResource::getParentId, id));
        if(CollectionUtils.isEmpty(childrenList)){
            s.setChildren(Collections.emptyList());
        }else{
            s.setChildren(childrenList);
            for(SysResource c : childrenList){
                findAllChildren(c);
            }
        }
    }

    @Override
    public SysResource findById(Long id) {
        SysResource resource = baseMapper.selectOne(new MPJLambdaWrapper<SysResource>()
                .eq(SysResource::getId, id));
        findParent(resource);
        return resource;
//        return sysResourceMapper.findById(id);
    }

    @Override
    public int add(SysResource sysResource) {
        if(sysResource.getParentId() == 0){
            sysResource.setLevel(1);
        }else{
            SysResource parent = this.findById(sysResource.getParentId());
            if(parent != null){
                sysResource.setLevel(parent.getLevel() + 1);
            }
        }
        return baseMapper.insert(sysResource);
//        return sysResourceMapper.add(sysResource);
    }

    @Override
    public int update(SysResource sysResource) {
        if(sysResource.getParentId() == 0){
            sysResource.setLevel(1);
        }else{
            SysResource parent = this.findById(sysResource.getParentId());
            if(parent != null){
                sysResource.setLevel(parent.getLevel() + 1);
            }
        }
        log.debug(sysResource.toString());
        return baseMapper.updateById(sysResource);
//        return sysResourceMapper.update(sysResource);
    }

    @Override
    public int delete(Long[] ids) {
//        int rows = 0;
//        for(Long id : ids){
//            rows += sysResourceMapper.delete(id);
//        }
//        return rows;
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
