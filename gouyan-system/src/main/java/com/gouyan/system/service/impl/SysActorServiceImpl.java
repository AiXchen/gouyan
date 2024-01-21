package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.common.utils.StringUtil;
import com.gouyan.system.domin.SysActor;
import com.gouyan.system.domin.SysActorMovie;
import com.gouyan.system.domin.SysActorRole;
import com.gouyan.system.domin.SysMovie;
import com.gouyan.system.mapper.SysActorMapper;
import com.gouyan.system.service.SysActorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author lxd
 * @create 2020-11-23 15:36
 */

@Service
public class SysActorServiceImpl extends ServiceImpl<SysActorMapper,SysActor> implements SysActorService {

    @Autowired
    private SysActorMapper sysActorMapper;

    @Override
    public List<SysActor> findAll(SysActor sysActor) {
        MPJLambdaWrapper<SysActor> wrapper = new MPJLambdaWrapper<>();
        wrapper.like(StringUtil.isNotEmpty(sysActor.getActorName()),
                SysActor::getActorName,sysActor.getActorName())
                .like(StringUtil.isNotEmpty(sysActor.getActorSchool()),
                        SysActor::getActorSchool,sysActor.getActorSchool());
        if(Optional.ofNullable(sysActor.getActorGender()).isPresent()){
            wrapper.eq(SysActor::getActorGender,sysActor.getActorGender());
        }
        return baseMapper.selectList(wrapper);
//        return sysActorMapper.findAll(sysActor);
    }

    @Override
    public SysActor findById(Long id) {
        return baseMapper.selectById(id);
//        return sysActorMapper.findById(id);
    }

    @Override
    public int add(SysActor sysActor) {
        SysActor actor = new SysActor();
        BeanUtils.copyProperties(sysActor,actor);
        return baseMapper.insert(actor);
//        return sysActorMapper.add(sysActor);
    }

    @Override
    public int update(SysActor sysActor) {
        return baseMapper.updateById(sysActor);
//        return sysActorMapper.update(sysActor);
    }

    @Override
    public int delete(Long[] ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
//        int rows = 0;
//        for (Long id : ids) {
//            rows += sysActorMapper.delete(id);
//        }
//        return rows;
    }

    @Override
    public SysActor findActorById(Long id) {
//        MPJLambdaWrapper<SysActor> wrapper = new MPJLambdaWrapper<>();
//        wrapper.selectAll(SysActor.class)
//                .selectAssociation(SysActorRole.class,SysActor::getActorRoleList)
//                .selectAssociation(SysMovie.class,SysActor::getMovieList)
//                .innerJoin(SysActorMovie.class,SysActorMovie::getActorId,SysActor::getActorId)
//                .innerJoin(SysMovie.class,SysMovie::getMovieId,SysActorMovie::getMovieId)
//                .innerJoin(SysActorRole.class,SysActorRole::getActorRoleId,SysActorMovie::getActorRoleId)
//                .eq(SysActor::getActorId,id)
//                .orderByDesc(SysMovie::getReleaseDate);
//        return baseMapper.selectOne(wrapper);
        return sysActorMapper.findActorById(id);
    }
}
