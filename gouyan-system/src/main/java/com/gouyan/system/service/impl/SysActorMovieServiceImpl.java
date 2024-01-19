package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.common.utils.StringUtil;
import com.gouyan.system.domin.SysActorMovie;
import com.gouyan.system.mapper.SysActorMovieMapper;
import com.gouyan.system.service.SysActorMovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author lxd
 * @create 2020-11-27 10:28
 */
@Service
public class SysActorMovieServiceImpl extends ServiceImpl<SysActorMovieMapper,SysActorMovie> implements SysActorMovieService {

    @Autowired
    private SysActorMovieMapper sysActorMovieMapper;

    @Override
    public List<SysActorMovie> findAll(SysActorMovie sysActorMovie) {
        return baseMapper.selectList(null);
//        return sysActorMovieMapper.findAll(sysActorMovie);
    }

    @Override
    public int add(SysActorMovie sysActorMovie) {
        SysActorMovie actorMovie = new SysActorMovie();
        BeanUtils.copyProperties(sysActorMovie,actorMovie);
        return baseMapper.insert(actorMovie);

//        return sysActorMovieMapper.add(sysActorMovie);
    }

    @Override
    public int delete(SysActorMovie sysActorMovie) {
        MPJLambdaWrapper<SysActorMovie> wrapper = new MPJLambdaWrapper<>();
        if(Optional.ofNullable(sysActorMovie.getMovieId()).isPresent()){
            wrapper.eq(SysActorMovie::getMovieId, sysActorMovie.getMovieId() );
        }
        if(Optional.ofNullable(sysActorMovie.getActorId()).isPresent()){
            wrapper.eq(SysActorMovie::getActorId, sysActorMovie.getActorId() );
        }
        if(Optional.ofNullable(sysActorMovie.getActorRoleId()).isPresent()){
            wrapper.eq(SysActorMovie::getActorRoleId, sysActorMovie.getActorRoleId() );
        }
        return baseMapper.delete(wrapper);
//        return sysActorMovieMapper.delete(sysActorMovie);
    }
}
