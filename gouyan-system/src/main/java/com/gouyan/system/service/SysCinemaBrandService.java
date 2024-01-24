package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysCinemaBrand;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/24 17:39
 */
public interface SysCinemaBrandService extends IService<SysCinemaBrand> {
    List<SysCinemaBrand> findAll();

    SysCinemaBrand findById(Long id);

    int add(SysCinemaBrand sysCinemaBrand);

    int update(SysCinemaBrand sysCinemaBrand);

    int delete(Long[] ids);
}
