package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.common.utils.StringUtil;
import com.gouyan.system.domin.SysBill;
import com.gouyan.system.domin.SysUser;
import com.gouyan.system.mapper.SysBillMapper;
import com.gouyan.system.service.SysBillService;
import com.gouyan.system.service.SysSessionService;
import com.gouyan.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Aixchen
 * @date 2024/1/24 15:01
 */
@Service
public class SysBillServiceImpl extends ServiceImpl<SysBillMapper,SysBill> implements SysBillService {

    @Autowired
    private SysBillMapper sysBillMapper;
    @Autowired
    private SysSessionService sysSessionService;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public List<SysBill> findAll(SysBill sysBill) {
        return sysBillMapper.findAll(sysBill);
    }


    @Override
    public SysBill findById(Long id) {
        SysBill bill = baseMapper.selectById(id);
        bill.setSysUser(sysUserService.findById(bill.getUserId()));
        bill.setSysSession(sysSessionService.findById(bill.getSessionId()));
        return bill;
//        return sysBillMapper.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object add(SysBill sysBill) {
        if(sysBill.getBillDate() == null){
            sysBill.setBillDate(new Date());
        }
        baseMapper.insert(sysBill);
        return sysBill;
//        int rows = sysBillMapper.add(sysBill);
//        return rows > 0 ? sysBill : rows;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(SysBill sysBill) {
        return baseMapper.updateById(sysBill);
//        return sysBillMapper.update(sysBill);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
