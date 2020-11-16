package com.gouyan.system.service;

import com.gouyan.system.domin.SysMovieAge;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 华雨欣
 * @Create: 2020-11-14 22:57
 */
public interface SysMovieAgeService {

    List<SysMovieAge> findAll();

    SysMovieAge findById(Long id);

    void add(SysMovieAge sysMovieAge);

    void update(SysMovieAge sysMovieAge);

    void delete(Long[] ids);

}
