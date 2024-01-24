package com.gouyan.system.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.gouyan.system.domin.SysActor;
import com.gouyan.system.domin.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/24 17:38
 */
@Mapper
public interface SysActorMapper extends MPJBaseMapper<SysActor>{
    List<SysActor> findAll(SysActor sysActor);

    SysActor findById(Long id);

    int add(SysActor sysActor);

    int update(SysActor sysActor);

    int delete(Long id);

    SysActor findActorById(Long id);

    /**
     * 根据电影id查询所有主演名称
     * @param id
     * @return
     */
    List<String> findaMajorActorNames(Long id);
}
