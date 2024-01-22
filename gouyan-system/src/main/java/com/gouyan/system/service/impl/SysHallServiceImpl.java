package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.common.utils.StringUtil;
import com.gouyan.system.domin.SysCinema;
import com.gouyan.system.domin.SysHall;
import com.gouyan.system.domin.SysHallCategory;
import com.gouyan.system.domin.vo.SysHallOutput;
import com.gouyan.system.mapper.SysHallMapper;
import com.gouyan.system.service.SysHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Aixchen
 * @date 2024/1/22 14:49
 */

@Service
public class SysHallServiceImpl extends ServiceImpl<SysHallMapper,SysHall> implements SysHallService {

    @Autowired
    private SysHallMapper sysHallMapper;

    @Override
    public List<SysHall> findAll(SysHall sysHall) {
        MPJLambdaWrapper<SysHall> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysHall.class);
        addCondition(wrapper,sysHall);
        return baseMapper.selectList(wrapper);
//        return sysHallMapper.findAll(sysHall);
    }

    private void addCondition(MPJLambdaWrapper<SysHall> wrapper, SysHall sysHall) {
        if(Optional.ofNullable(sysHall.getCinemaId()).isPresent()){
            wrapper.eq(SysHall::getCinemaId, sysHall.getCinemaId() );
        }
        if(Optional.ofNullable(sysHall.getHallCategoryId()).isPresent()){
            wrapper.eq(SysHall::getHallCategoryId, sysHall.getHallCategoryId() );
        }
        wrapper.like(StringUtil.isNotEmpty(sysHall.getHallName()),
                SysHall::getHallName,sysHall.getHallName());
        wrapper.eq(sysHall.getHallState() != null && sysHall.getHallState(),
                SysHall::getHallState,sysHall.getHallState()  );
    }

    @Override
    public SysHall findByCinemaIdAndHallId(SysHall sysHall) {
//        MPJLambdaWrapper<SysHall> wrapper = new MPJLambdaWrapper<>();
//        wrapper.selectAs(SysHall::getHallId, SysHallOutput::getHallId)
//                .selectAs(SysHall::getCinemaId, SysHallOutput::getCinemaId)
//                .selectAs(SysHall::getHallCategoryId, SysHallOutput::getHallCategoryId)
//                .leftJoin(SysCinema.class, SysCinema::getCinemaId,SysHall::getCinemaId)
//                .leftJoin(SysHallCategory.class,SysHallCategory::getHallCategoryId,SysHall::getHallCategoryId)
//                .selectAssociation(SysCinema.class, SysHallOutput::getSysCinema)
//                .selectAssociation(SysHallCategory.class, SysHallOutput::getSysHallCategory)
//                .eq(SysHall::getCinemaId, sysHall.getCinemaId())
//                .eq(SysHall::getHallId, sysHall.getHallId() );
        return sysHallMapper.findByCinemaIdAndHallId(sysHall);
    }

    @Override
    public int add(SysHall sysHall) {
        return baseMapper.insert(sysHall);
//        return sysHallMapper.add(sysHall);
    }

    @Override
    public int update(SysHall sysHall) {
        return baseMapper.update(sysHall);
//        return sysHallMapper.update(sysHall);
    }

    @Override
    public int delete(SysHall[] sysHalls) {
        List<Long> idList = Arrays.asList(sysHalls).stream().map(i -> {
            return i.getHallId();
        }).collect(Collectors.toList());
        return baseMapper.deleteBatchIds(idList);
//        int rows = 0;
//        for (SysHall sysHall : sysHalls) {
//            rows += sysHallMapper.delete(sysHall);
//        }
//        return rows;
    }
}
