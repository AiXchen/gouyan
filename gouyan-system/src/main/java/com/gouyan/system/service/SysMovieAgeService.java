package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysMovieAge;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 15:12
 */
public interface SysMovieAgeService extends IService<SysMovieAge> {

    List<SysMovieAge> findAll();

    SysMovieAge findById(Long id);

    int add(SysMovieAge sysMovieAge);

    int update(SysMovieAge sysMovieAge);

    int delete(Long[] ids);

}
