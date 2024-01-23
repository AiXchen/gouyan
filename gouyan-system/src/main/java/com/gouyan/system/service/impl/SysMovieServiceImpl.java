package com.gouyan.system.service.impl;

import ch.qos.logback.core.util.StringCollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.common.utils.StringUtil;
import com.gouyan.system.domin.*;
import com.gouyan.system.domin.vo.SysMovieVo;
import com.gouyan.system.mapper.*;
import com.gouyan.system.service.SysMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

/**
 * @author Aixchen
 * @date 2024/1/22 14:50
 */
@Service
public class SysMovieServiceImpl extends ServiceImpl<SysMovieMapper,SysMovie> implements SysMovieService{

    @Autowired
    private SysMovieMapper sysMovieMapper;
    @Autowired
    private SysMovieAreaMapper sysMovieAreaMapper;
    @Autowired
    private SysMovieAgeMapper sysMovieAgeMapper;
    @Autowired
    private SysMovieCategoryMapper sysMovieCategoryMapper;
    @Autowired
    private SysActorMapper sysActorMapper;

    @Override
    public List<SysMovie> findAll(SysMovieVo sysMovieVo) {
        MPJLambdaWrapper<SysMovie> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysMovie.class);
        addCondition(wrapper,sysMovieVo);
        return baseMapper.selectList(wrapper);
//        return sysMovieMapper.findAll(sysMovieVo);
    }

    private void addCondition(MPJLambdaWrapper<SysMovie> wrapper, SysMovieVo sysMovieVo) {
        if(Optional.ofNullable(sysMovieVo.getMovieCategoryId()).isPresent() && sysMovieVo.getMovieCategoryId() > 0){
            wrapper.leftJoin(SysMovieToCategory.class,SysMovieToCategory::getMovieId,SysMovie::getMovieId)
                    .leftJoin(SysMovieCategory.class,SysMovieCategory::getMovieCategoryId,SysMovieToCategory::getMovieCategoryId);
        }
        if(Optional.ofNullable(sysMovieVo.getMovieAgeId()).isPresent() && sysMovieVo.getMovieAgeId() > 0){
            wrapper.eq(SysMovie::getMovieAgeId, sysMovieVo.getMovieAgeId());
        }
        if(Optional.ofNullable(sysMovieVo.getMovieAreaId()).isPresent() && sysMovieVo.getMovieAreaId() > 0){
            wrapper.eq(SysMovie::getMovieAreaId, sysMovieVo.getMovieAreaId());
        }
        if(Optional.ofNullable(sysMovieVo.getMovieCategoryId()).isPresent() && sysMovieVo.getMovieCategoryId() > 0){
            wrapper.eq(SysMovieCategory::getMovieCategoryId, sysMovieVo.getMovieCategoryId());
        }
        wrapper.like(StringUtil.isNotEmpty(sysMovieVo.getMovieNameCn()),
                SysMovie::getMovieNameCn,sysMovieVo.getMovieNameCn());
        wrapper.like(StringUtil.isNotEmpty(sysMovieVo.getMovieNameEn()),
                SysMovie::getMovieNameEn,sysMovieVo.getMovieNameEn());
        wrapper.ge(sysMovieVo.getStartDate() != null,
                SysMovie::getReleaseDate, sysMovieVo.getStartDate());
        wrapper.le(sysMovieVo.getEndDate() != null,
                SysMovie::getReleaseDate,sysMovieVo.getEndDate());

    }

    @Override
    public SysMovie findById(Long id) {
//        return baseMapper.selectById(id);
        return sysMovieMapper.findById(id);
    }

    @Override
    public SysMovie findOne(Long id) {
        return baseMapper.selectById(id);
//        return sysMovieMapper.findOne(id);
    }

    @Override
    public int add(SysMovie sysMovie) {
        return baseMapper.insert(sysMovie);
//        return sysMovieMapper.add(sysMovie);
    }

    @Override
    public int update(SysMovie sysMovie) {
        return baseMapper.updateById(sysMovie);
//        return sysMovieMapper.update(sysMovie);
    }

    @Override
    public int delete(Long[] ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
//        int rows = 0;
//        for(Long id : ids){
//            rows += sysMovieMapper.delete(id);
//        }
//        return rows;
    }

    @Override
    public SysMovie findMovieById(Long id) {
        return sysMovieMapper.findMovieById(id);
    }

    @Override
    public List<SysMovie> findByCinemaId(Long id) {
        return sysMovieMapper.findByCinemaId(id);
    }

    /**
     * 热映口碑榜 昨日热映的电影里，按评分取前10
     * @return
     */
    @Override
    public List<SysMovie> hotMovieList() {
//        Date date = new Date();
//        // 创建Calendar对象并设置为当前日期
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        // 减去一天
//        cal.add(Calendar.DAY_OF_MONTH, -1);
//        // 获取减去一天后的日期
//        Date previousDate = cal.getTime();
//
//        MPJLambdaWrapper<SysMovie> wrapper = new MPJLambdaWrapper<>();
//        wrapper.selectAll(SysMovie.class)
//                .leftJoin(SysSession.class,SysSession::getMovieId,SysMovie::getMovieId)
//                .eq(SysSession::getSessionDate, previousDate );
//        List<SysMovie> movieList = baseMapper.selectList(wrapper);
//        for(SysMovie m : movieList){
//            setValue(m);
//        }
//        return movieList;
        return sysMovieMapper.hotMovieList();
    }

    private void setValue(SysMovie m) {
        m.setSysMovieArea(sysMovieAreaMapper.selectById(m.getMovieAreaId()));
        m.setSysMovieAge(sysMovieAgeMapper.selectById(m.getMovieAgeId()));

        MPJLambdaWrapper<SysMovieCategory> categoryWrapper = new MPJLambdaWrapper<>();
        categoryWrapper.selectAll(SysMovieCategory.class)
                .leftJoin(SysMovieToCategory.class,SysMovieToCategory::getMovieCategoryId,SysMovieCategory::getMovieCategoryId)
                .eq(SysMovieToCategory::getMovieId, m.getMovieId() );
        m.setMovieCategoryList(sysMovieCategoryMapper.selectList(categoryWrapper));

        MPJLambdaWrapper<SysActor> actorWrapper = new MPJLambdaWrapper<>();
        actorWrapper.select(SysActor::getActorName)
                .leftJoin(SysActorMovie.class,SysActorMovie::getActorId,SysActor::getActorId)
//                .eq(SysActorMovie::getActorId, 2 )
                .eq(SysActorMovie::getMovieId, m.getMovieId() );
        m.setMajorActorNameList(sysActorMapper.selectJoinList(String.class, actorWrapper));
    }

    /**
     * 国内票房榜 已上映的国内电影里，按票房取前10 国内电影 areaid = 1、5、6
     * @return
     */
    @Override
    public List<SysMovie> domesticBoxOfficeList() {
        MPJLambdaWrapper<SysMovie> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysMovie.class)
                .in(SysMovie::getMovieAreaId, Arrays.asList(1,5,6))
                .le(SysMovie::getReleaseDate, new Date() )
                .orderByDesc(SysMovie::getMovieBoxOffice);
        List<SysMovie> movieList = baseMapper.selectList(wrapper);
        for(SysMovie s : movieList){
            setValue(s);
        }
        return movieList;
//        return sysMovieMapper.domesticBoxOfficeList();
    }

    /**
     * 欧美票房榜 已上映的欧美电影里，按票房取前10 欧美电影 areaid = 2、9、10、11、12、13、14
     * @return
     */
    @Override
    public List<SysMovie> europeanAndAmericanBoxOfficeList() {
        MPJLambdaWrapper<SysMovie> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysMovie.class)
                .in(SysMovie::getMovieAreaId, Arrays.asList(2, 9, 10, 11, 12, 13, 14))
                .le(SysMovie::getReleaseDate, new Date() )
                .orderByDesc(SysMovie::getMovieBoxOffice);
        List<SysMovie> movieList = baseMapper.selectList(wrapper);
        for(SysMovie s : movieList){
            setValue(s);
        }
        return movieList;
//        return sysMovieMapper.europeanAndAmericanBoxOfficeList();
    }

    /**
     * top100榜 所有已上映影片按评分、评分人数取前100
     * @return
     */
    @Override
    public List<SysMovie> top100List() {
        MPJLambdaWrapper<SysMovie> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysMovie.class)
                .le(SysMovie::getReleaseDate, new Date() )
                .orderByDesc(SysMovie::getMovieScore,SysMovie::getMovieRateNum);
        List<SysMovie> movieList = baseMapper.selectList(wrapper);
        for(SysMovie s : movieList){
            setValue(s);
        }
        return movieList;
//        return sysMovieMapper.top100List();
    }
}
