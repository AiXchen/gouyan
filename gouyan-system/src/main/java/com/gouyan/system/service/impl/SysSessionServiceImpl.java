package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.system.domin.*;
import com.gouyan.system.domin.vo.SysSessionVo;
import com.gouyan.system.mapper.SysSessionMapper;
import com.gouyan.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Aixchen
 * @date 2024/1/22 17:29
 */
@Service
public class SysSessionServiceImpl extends ServiceImpl<SysSessionMapper,SysSession> implements SysSessionService {

    @Autowired
    private SysSessionMapper sysSessionMapper;
    @Autowired
    private SysCinemaService sysCinemaService;
    @Autowired
    private SysHallService sysHallService;
    @Autowired
    private SysMovieService sysMovieService;
    @Autowired
    private SysMovieRuntimeService sysMovieRuntimeService;

    @Override
    public List<SysSession> findByVo(SysSessionVo sysSessionVo) {
        MPJLambdaWrapper<SysSession> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysSession.class)
                .leftJoin(SysCinema.class, SysCinema::getCinemaId,SysSession::getCinemaId)
                .leftJoin(SysHall.class, on -> on
                        .eq(SysHall::getCinemaId,SysSession::getCinemaId)
                        .eq(SysHall::getHallId,SysSession::getHallId))
                .leftJoin(SysMovie.class, SysMovie::getMovieId,SysSession::getMovieId)
                .leftJoin(SysMovieRuntime.class,SysMovieRuntime::getMovieRuntimeId,SysSession::getMovieRuntimeId);
        addCondition(wrapper,sysSessionVo);
        List<SysSession> sessionList = baseMapper.selectList(wrapper);
        for(SysSession s : sessionList){
            setValue(s);
        }
        return sessionList;
//        return sysSessionMapper.findByVo(sysSessionVo);
    }

    //sysCinema->findById/sysHall->findByCinemaIdAndHallId/sysMovie->findById/sysMovieRuntime->findById
    private void setValue(SysSession s) {
        s.setSysCinema(sysCinemaService.findById(s.getCinemaId()));
        s.setSysHall(sysHallService.findByCinemaIdAndHallId(SysHall.builder().cinemaId(s.getCinemaId()).hallId(s.getHallId()).build()));
        s.setSysMovie(sysMovieService.findById(s.getMovieId()));
        s.setSysMovieRuntime(sysMovieRuntimeService.findById(s.getMovieRuntimeId()));
    }

    //cinemaId/hallId/movieId/movieRuntimeId/sessionDate
    private void addCondition(MPJLambdaWrapper<SysSession> wrapper, SysSessionVo sysSessionVo) {
        if(Optional.ofNullable(sysSessionVo.getCinemaId()).isPresent()){
            wrapper.eq(SysSession::getCinemaId,sysSessionVo.getCinemaId());
        }
        if(Optional.ofNullable(sysSessionVo.getHallId()).isPresent()){
            wrapper.eq(SysSession::getHallId,sysSessionVo.getHallId());
        }
        if(Optional.ofNullable(sysSessionVo.getMovieId()).isPresent()){
            wrapper.eq(SysSession::getMovieId,sysSessionVo.getMovieId());
        }
        wrapper.eq(sysSessionVo.getSessionDate() != null,
                SysSession::getSessionDate, sysSessionVo.getSessionDate());
    }

    @Override
    public SysSession findById(Long id) {
        MPJLambdaWrapper<SysSession> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysSession.class)
                .eq(SysSession::getSessionId, id);
        SysSession session = baseMapper.selectOne(wrapper);
        setValue(session);
        return session;
//        return baseMapper.selectById(id);
//        return sysSessionMapper.findById(id);
    }

    @Override
    public SysSession findOne(Long id){
        return baseMapper.selectById(id);
//        return sysSessionMapper.findOne(id);
    }

    @Override
    public int add(SysSession sysSession) {
        return baseMapper.add(sysSession);
//        return sysSessionMapper.add(sysSession);
    }

    @Override
    public int update(SysSession sysSession) {
        return baseMapper.updateById(sysSession);
//        return sysSessionMapper.update(sysSession);
    }

    @Override
    public int delete(Long[] ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
//        int rows = 0;
//        for(Long id : ids){
//            rows += sysSessionMapper.delete(id);
//        }
//        return rows;
    }

    @Override
    public List<SysSession> findByCinemaAndMovie(Long cinemaId, Long movieId) {
        return sysSessionMapper.findByCinemaAndMovie(cinemaId, movieId);
    }
}
