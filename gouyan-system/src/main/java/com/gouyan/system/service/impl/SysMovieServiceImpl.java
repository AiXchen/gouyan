package com.gouyan.system.service.impl;

import ch.qos.logback.core.util.StringCollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.common.utils.StringUtil;
import com.gouyan.system.domin.SysMovie;
import com.gouyan.system.domin.SysMovieCategory;
import com.gouyan.system.domin.SysMovieToCategory;
import com.gouyan.system.domin.vo.SysMovieVo;
import com.gouyan.system.mapper.SysMovieMapper;
import com.gouyan.system.service.SysMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

/**
 * @author Aixchen
 * @date 2024/1/22 14:50
 */
@Service
public class SysMovieServiceImpl extends ServiceImpl<SysMovieMapper,SysMovie> implements SysMovieService{

    @Autowired
    private SysMovieMapper sysMovieMapper;

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
        if(Optional.ofNullable(sysMovieVo.getMovieAgeId()).isPresent()){
            wrapper.eq(SysMovie::getMovieAgeId, sysMovieVo.getMovieAgeId());
        }
        if(Optional.ofNullable(sysMovieVo.getMovieAreaId()).isPresent()){
            wrapper.eq(SysMovie::getMovieAreaId, sysMovieVo.getMovieAreaId());
        }
        if(Optional.ofNullable(sysMovieVo.getMovieCategoryId()).isPresent()){
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
        return sysMovieMapper.hotMovieList();
    }

    /**
     * 国内票房榜 已上映的国内电影里，按票房取前10 国内电影 areaid = 1、5、6
     * @return
     */
    @Override
    public List<SysMovie> domesticBoxOfficeList() {
        return sysMovieMapper.domesticBoxOfficeList();
    }

    /**
     * 欧美票房榜 已上映的欧美电影里，按票房取前10 欧美电影 areaid = 2、9、10、11、12、13、14
     * @return
     */
    @Override
    public List<SysMovie> europeanAndAmericanBoxOfficeList() {
        return sysMovieMapper.europeanAndAmericanBoxOfficeList();
    }

    /**
     * top100榜 所有已上映影片按评分、评分人数取前100
     * @return
     */
    @Override
    public List<SysMovie> top100List() {
        return sysMovieMapper.top100List();
    }
}
