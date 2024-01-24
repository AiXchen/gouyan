package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysActor;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/24 17:38
 */
public interface SysActorService extends IService<SysActor> {
    List<SysActor> findAll(SysActor sysActor);

    SysActor findById(Long id);

    int add(SysActor sysActor);

    int update(SysActor sysActor);

    int delete(Long[] ids);

    SysActor findActorById(Long id);

    /**
     * 根据电影id查询所有主演名称
     * @param id
     * @return
     */
    List<String> findMajorActorNames(Long id);
}
