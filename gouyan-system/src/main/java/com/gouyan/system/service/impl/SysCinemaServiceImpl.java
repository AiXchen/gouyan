package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.common.utils.StringUtil;
import com.gouyan.system.domin.*;
import com.gouyan.system.domin.vo.SysCinemaVo;
import com.gouyan.system.mapper.SysCinemaMapper;
import com.gouyan.system.service.SysCinemaService;
import jdk.nashorn.internal.runtime.StoredScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author lxd
 * @create 2020-11-25 22:24
 */
@Service
public class SysCinemaServiceImpl extends ServiceImpl<SysCinemaMapper,SysCinema> implements SysCinemaService{

    @Autowired
    private SysCinemaMapper sysCinemaMapper;


    @Override
    public List<SysCinema> findAll(SysCinemaVo sysCinemaVo) {
        MPJLambdaWrapper<SysCinema> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysCinema.class);
        addCondition(wrapper,sysCinemaVo);
        return baseMapper.selectList(wrapper);
//        return sysCinemaMapper.findAll(sysCinemaVo);
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
        return baseMapper.selectById(id);
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
//        MPJLambdaWrapper<SysCinema> wrapper = new MPJLambdaWrapper<>();
//        wrapper.selectAll(SysCinema.class)
//                .leftJoin(SysUser.class,SysUser::getUserId,SysCinema::getUserId)
//                .leftJoin(SysCinemaBrand.class,SysCinemaBrand::getCinemaBrandId,SysCinema::getCinemaBrandId)
//                .leftJoin(SysCinemaArea.class,SysCinemaArea::getCinemaAreaId,SysCinema::getCinemaAreaId)
//                .leftJoin(SysSession.class,SysSession::getCinemaId,SysCinema::getCinemaId)
//                .leftJoin(SysMovie.class,SysMovie::getMovieId,SysSession::getMovieId)
//                .selectAssociation(SysUser.class, SysCinema::getUser)
//                .selectAssociation(SysCinemaBrand.class, SysCinema::getSysCinemaBrand)
//                .selectAssociation(SysCinemaArea.class,SysCinema::getSysCinemaArea)
//                .selectCollection(SysMovie.class, SysCinema::getSysMovieList);
//        return baseMapper.selectOne(wrapper);

        return sysCinemaMapper.findCinemaById(id);
    }
}
