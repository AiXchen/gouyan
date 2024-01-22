package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysCinemaArea;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-20 09:15
 */
public interface SysCinemaAreaService extends IService<SysCinemaArea> {

    List<SysCinemaArea> findAll();

    SysCinemaArea findById(Long id);

    int add(SysCinemaArea sysCinemaArea);

    int update(SysCinemaArea sysCinemaArea);

    int delete(Long[] ids);

}
