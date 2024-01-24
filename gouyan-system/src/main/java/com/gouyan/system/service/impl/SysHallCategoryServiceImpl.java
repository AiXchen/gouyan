package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.query.MPJLambdaQueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.system.domin.SysHall;
import com.gouyan.system.domin.SysHallCategory;
import com.gouyan.system.mapper.SysHallCategoryMapper;
import com.gouyan.system.service.SysHallCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 14:09
 */
@Service
public class SysHallCategoryServiceImpl extends ServiceImpl<SysHallCategoryMapper,SysHallCategory> implements SysHallCategoryService {

    @Autowired
    private SysHallCategoryMapper sysHallCategoryMapper;

    @Override
    public List<SysHallCategory> findAll() {
        return baseMapper.selectList(null);
//        return sysHallCategoryMapper.findAll();
    }

    @Override
    public SysHallCategory findById(Long id) {
        return baseMapper.selectById(id);
//        return sysHallCategoryMapper.findById(id);
    }

    @Override
    public int add(SysHallCategory sysHallCategory) {
        return baseMapper.insert(sysHallCategory);
//        return sysHallCategoryMapper.add(sysHallCategory);
    }

    @Override
    public int update(SysHallCategory sysHallCategory) {
        return baseMapper.updateById(sysHallCategory);
//        return sysHallCategoryMapper.update(sysHallCategory);
    }

    @Override
    public int delete(Long[] ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
//        int rows = 0;
//        for (Long id : ids) {
//            rows += sysHallCategoryMapper.delete(id);
//        }
//        return rows;
    }

    @Override
    public List<SysHallCategory> findByCinemaId(Long id) {
        MPJLambdaWrapper<SysHallCategory> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysHallCategory.class)
                .leftJoin(SysHall.class,SysHall::getHallCategoryId,SysHallCategory::getHallCategoryId)
                .eq(SysHall::getCinemaId, id)
                .distinct();
        return baseMapper.selectList(wrapper);
    }
}
