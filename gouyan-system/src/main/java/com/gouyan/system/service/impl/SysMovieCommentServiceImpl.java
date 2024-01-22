package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.system.domin.SysMovie;
import com.gouyan.system.domin.SysMovieComment;
import com.gouyan.system.domin.SysUser;
import com.gouyan.system.mapper.SysMovieCommentMapper;
import com.gouyan.system.service.SysMovieCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 15:26
 */
@Service
public class SysMovieCommentServiceImpl extends ServiceImpl<SysMovieCommentMapper,SysMovieComment> implements SysMovieCommentService {

    @Autowired
    private SysMovieCommentMapper sysMovieCommentMapper;

    @Override
    public List<SysMovieComment> findAll() {
//        MPJLambdaWrapper<SysMovieComment> wrapper = new MPJLambdaWrapper<>();
//        wrapper.selectAll(SysMovieComment.class)
//                .selectAssociation(SysUser.class, SysMovieComment::getSysUser)
//                .selectAssociation(SysMovie.class, SysMovieComment::getSysMovie)
//                .leftJoin(SysUser.class,SysUser::getUserId,SysMovieComment::getUserId)
//                .leftJoin(SysMovie.class,SysMovie::getMovieId,SysMovieComment::getMovieId);
//        return baseMapper.selectList(wrapper);
        return sysMovieCommentMapper.findAll();
    }

    @Override
    public SysMovieComment findOne(SysMovieComment sysMovieComment) {
        return baseMapper.selectOne(new MPJLambdaWrapper<SysMovieComment>()
                .eq(SysMovieComment::getMovieId, sysMovieComment.getMovieId())
                .eq(SysMovieComment::getUserId, sysMovieComment.getUserId() )
                .eq(SysMovieComment::getCommentTime, sysMovieComment.getCommentTime() ));

//        return sysMovieCommentMapper.findOne(sysMovieComment);
    }

    @Override
    public List<SysMovieComment> findByMovieId(Long movieId) {
//        MPJLambdaWrapper<SysMovieComment> wrapper = new MPJLambdaWrapper<>();
//        wrapper.selectAll(SysMovieComment.class)
//                .selectAssociation(SysUser.class, SysMovieComment::getSysUser)
//                .selectAssociation(SysMovie.class, SysMovieComment::getSysMovie)
//                .leftJoin(SysUser.class,SysUser::getUserId,SysMovieComment::getUserId)
//                .leftJoin(SysMovie.class,SysMovie::getMovieId,SysMovieComment::getMovieId)
//                .eq(SysMovieComment::getMovieId, movieId);
//        return baseMapper.selectList(wrapper);
        return sysMovieCommentMapper.findByMovieId(movieId);
    }

    @Override
    public List<SysMovieComment> findByUserId(Long userId) {
//        MPJLambdaWrapper<SysMovieComment> wrapper = new MPJLambdaWrapper<>();
//        wrapper.selectAll(SysMovieComment.class)
//                .selectAssociation(SysUser.class, SysMovieComment::getSysUser)
//                .selectAssociation(SysMovie.class, SysMovieComment::getSysMovie)
//                .leftJoin(SysUser.class,SysUser::getUserId,SysMovieComment::getUserId)
//                .leftJoin(SysMovie.class,SysMovie::getMovieId,SysMovieComment::getMovieId)
//                .eq(SysMovieComment::getMovieId, userId);
//        return baseMapper.selectList(wrapper);
        return sysMovieCommentMapper.findByUserId(userId);
    }

    @Override
    public int add(SysMovieComment sysMovieComment) {
        return baseMapper.insert(sysMovieComment);
//        return sysMovieCommentMapper.add(sysMovieComment);
    }

    @Override
    public int update(SysMovieComment sysMovieComment) {
        return baseMapper.updateById(sysMovieComment);
//        return sysMovieCommentMapper.update(sysMovieComment);
    }

    @Override
    public int delete(SysMovieComment[] pks) {
        int rows = 0;
        for(SysMovieComment s : pks){
            baseMapper.delete(s);
            rows++;
        }
        return rows;
//        int rows = 0;
//        for(SysMovieComment pk : pks){
//            rows += sysMovieCommentMapper.delete(pk);
//        }
//        return rows;
    }
}
