package com.gouyan.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gouyan.system.domin.SysSession;
import com.gouyan.system.domin.vo.SysSessionVo;

import java.util.List;
/**
 * @author Aixchen
 * @date 2024/1/22 17:29
 */
public interface SysSessionService extends IService<SysSession> {

    List<SysSession> findByVo(SysSessionVo sysSessionVo);

    SysSession findById(Long id);

    SysSession findOne(Long id);

    int add(SysSession sysSession);

    int update(SysSession sysSession);

    int delete(Long[] id);

    List<SysSession> findByCinemaAndMovie(Long cinemaId, Long movieId);

}
