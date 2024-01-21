package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.common.utils.StringUtil;
import com.gouyan.system.domin.SysBill;
import com.gouyan.system.mapper.SysBillMapper;
import com.gouyan.system.service.SysBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-30 14:25
 */
@Service
public class SysBillServiceImpl extends ServiceImpl<SysBillMapper,SysBill> implements SysBillService {

    @Autowired
    private SysBillMapper sysBillMapper;

    @Override
    public List<SysBill> findAll(SysBill sysBill) {
        MPJLambdaWrapper<SysBill> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysBill.class);
        addCondition(wrapper,sysBill);
        return baseMapper.selectList(wrapper);
//        return sysBillMapper.findAll(sysBill);
    }

    private void addCondition(MPJLambdaWrapper<SysBill> wrapper, SysBill sysBill) {
        if(Optional.ofNullable(sysBill.getUserId()).isPresent()){
            wrapper.eq(SysBill::getUserId,sysBill.getUserId());
        }
        wrapper.eq(sysBill.getBillState(),SysBill::getBillState,sysBill.getBillState());
        wrapper.ge(SysBill::getBillDate,sysBill.getBillDate());
    }

    @Override
    public SysBill findById(Long id) {
        return baseMapper.selectById(id);
//        return sysBillMapper.findById(id);
    }

    @Override
    public Object add(SysBill sysBill) {
        return baseMapper.insert(sysBill);
//        int rows = sysBillMapper.add(sysBill);
//        return rows > 0 ? sysBill : rows;
    }

    @Override
    public int update(SysBill sysBill) {
        return baseMapper.updateById(sysBill);
//        return sysBillMapper.update(sysBill);
    }

    @Override
    public int delete(Long[] ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
//        int rows = 0;
////        for(Long id : ids){
////            rows += sysBillMapper.delete(id);
////        }
////        return rows;
    }

    @Override
    public Double todayBoxOffice() {
        return sysBillMapper.todayBoxOffice();
    }
}
