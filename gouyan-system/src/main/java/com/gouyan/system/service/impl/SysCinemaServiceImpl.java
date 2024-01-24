package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.common.utils.StringUtil;
import com.gouyan.system.domin.*;
import com.gouyan.system.domin.vo.SysCinemaVo;
import com.gouyan.system.mapper.SysCinemaMapper;
import com.gouyan.system.service.*;
import jdk.nashorn.internal.runtime.StoredScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Aixchen
 * @date 2024/1/24 15:29
 */
@Service
public class SysCinemaServiceImpl extends ServiceImpl<SysCinemaMapper,SysCinema> implements SysCinemaService{

    @Autowired
    private SysCinemaMapper sysCinemaMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysCinemaBrandService sysCinemaBrandService;
    @Autowired
    private SysCinemaAreaService sysCinemaAreaService;
    @Autowired
    private SysHallCategoryService sysHallCategoryService;
    @Autowired
    private SysMovieService sysMovieService;

    @Override
    public List<SysCinema> findAll(SysCinemaVo sysCinemaVo) {
        MPJLambdaWrapper<SysCinema> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysCinema.class);
        addCondition(wrapper,sysCinemaVo);
        List<SysCinema> sysCinemas = baseMapper.selectList(wrapper);
        for(SysCinema c : sysCinemas){
            setValue(c);
        }
        return sysCinemas;
//        return sysCinemaMapper.findAll(sysCinemaVo);
    }

    private void setValue(SysCinema c) {
        c.setUser(sysUserService.findById(c.getUserId()));
        c.setSysCinemaBrand(sysCinemaBrandService.findById(c.getCinemaBrandId()));
        c.setSysCinemaArea(sysCinemaAreaService.findById(c.getCinemaAreaId()));
        c.setSysHallCategoryList(sysHallCategoryService.findByCinemaId(c.getCinemaId()));
    }

    private void addCondition(MPJLambdaWrapper<SysCinema> wrapper, SysCinemaVo sysCinemaVo) {
        if(Optional.ofNullable(sysCinemaVo.getHallCategoryId()).isPresent() && sysCinemaVo.getHallCategoryId() > 0){
            wrapper.innerJoin(SysHall.class, SysHall::getCinemaId, SysCinema::getCinemaId )
                    .innerJoin(SysHallCategory.class, SysHallCategory::getHallCategoryId, SysHall::getHallCategoryId);
        }
        if(Optional.ofNullable(sysCinemaVo.getCinemaBrandId()).isPresent() && sysCinemaVo.getCinemaBrandId() > 0){
            wrapper.eq(SysCinema::getCinemaBrandId, sysCinemaVo.getCinemaBrandId() );
        }
        if(Optional.ofNullable(sysCinemaVo.getCinemaAreaId()).isPresent() && sysCinemaVo.getCinemaAreaId() > 0){
            wrapper.eq(SysCinema::getCinemaAreaId, sysCinemaVo.getCinemaAreaId() );
        }
        if(Optional.ofNullable(sysCinemaVo.getHallCategoryId()).isPresent() && sysCinemaVo.getHallCategoryId() > 0){
            wrapper.eq(SysHallCategory::getHallCategoryId, sysCinemaVo.getHallCategoryId() );
        }
        wrapper.like(StringUtil.isNotEmpty(sysCinemaVo.getCinemaName()),
                SysCinema::getCinemaName, sysCinemaVo.getCinemaName());
        wrapper.like(StringUtil.isNotEmpty(sysCinemaVo.getCinemaAddress()),
                SysCinema::getCinemaAddress,sysCinemaVo.getCinemaAddress());
        wrapper.eq(sysCinemaVo.getIsTicketChanged() != null && sysCinemaVo.getIsTicketChanged(),
                SysCinema::getIsTicketChanged, sysCinemaVo.getIsTicketChanged());
        wrapper.eq(sysCinemaVo.getIsRefunded() != null && sysCinemaVo.getIsRefunded(),
                SysCinema::getIsRefunded, sysCinemaVo.getIsRefunded());
    }

    @Override
    public SysCinema findById(Long id) {
        SysCinema cinema = baseMapper.selectById(id);
        setValue(cinema);
        return cinema;
//        return sysCinemaMapper.findById(id);
    }

    @Override
    public int add(SysCinema sysCinema) {
        return baseMapper.insert(sysCinema);
//        return sysCinemaMapper.add(sysCinema);
    }

    @Override
    public int update(SysCinema sysCinema) {
        return baseMapper.updateById(sysCinema);
//        return sysCinemaMapper.update(sysCinema);
    }

    @Override
    public int delete(Long[] ids) {
//        int rows = 0;
//        for (Long id : ids) {
//            rows += sysCinemaMapper.delete(id);
//        }
//        return rows;
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public SysCinema findCinemaById(Long id) {
        SysCinema cinema = baseMapper.selectOne(new MPJLambdaWrapper<SysCinema>()
                .eq(SysCinema::getCinemaId, id));
        cinema.setUser(sysUserService.findById(cinema.getUserId()));
        cinema.setSysCinemaBrand(sysCinemaBrandService.findById(cinema.getCinemaBrandId()));
        cinema.setSysCinemaArea(sysCinemaAreaService.findById(cinema.getCinemaAreaId()));
        cinema.setSysMovieList(sysMovieService.findByCinemaId(cinema.getCinemaId()));
        return cinema;
//        return sysCinemaMapper.findCinemaById(id);
    }
}
