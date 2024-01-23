package com.gouyan.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.gouyan.common.utils.JwtUtil;
import com.gouyan.common.utils.SaltUtils;
import com.gouyan.common.utils.StringUtil;
import com.gouyan.system.domin.LoginUser;
import com.gouyan.system.domin.SysRole;
import com.gouyan.system.domin.SysUser;
import com.gouyan.system.domin.vo.SysUserVo;
import com.gouyan.system.mapper.SysRoleMapper;
import com.gouyan.system.mapper.SysUserMapper;
import com.gouyan.system.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.ServiceUnavailableException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
/**
 * @author Aixchen
 * @date 2024/1/23 11:10
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysUser> findAll(SysUser sysUser) {
        MPJLambdaWrapper<SysUser> wrapper = new MPJLambdaWrapper<>();
        addCondition(wrapper,sysUser);
        List<SysUser> userList = baseMapper.selectList(wrapper);
        for(SysUser u : userList){
            findRole(u);
        }
        return userList;
//        wrapper.selectAll(SysUser.class)
//                .leftJoin(SysRole.class,SysRole::getRoleId,SysUser::getRoleId)
//                .selectAssociation(SysRole.class, SysUser::getSysRole);
//        addCondition(wrapper,sysUser);
//        return baseMapper.selectList(wrapper);


//        return sysUserMapper.findAll(sysUser);
    }

    private void findRole(SysUser u) {
        MPJLambdaWrapper<SysRole> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(SysRole.class)
                        .eq(SysRole::getRoleId, u.getRoleId() );
        SysRole role = sysRoleMapper.selectOne(wrapper);
        u.setSysRole(role);
    }

    private void addCondition(MPJLambdaWrapper<SysUser> wrapper, SysUser sysUser) {
        wrapper.like(StringUtil.isNotEmpty(sysUser.getUserName()),
                SysUser::getUserName,sysUser.getUserName());
        wrapper.like(StringUtil.isNotEmpty(sysUser.getEmail()),
                SysUser::getEmail,sysUser.getEmail());
        wrapper.like(StringUtil.isNotEmpty(sysUser.getPhoneNumber()),
                SysUser::getPhoneNumber,sysUser.getPhoneNumber());
        wrapper.eq(sysUser.getSex() != null,
                SysUser::getSex, sysUser.getSex());
    }

    @Override
    public SysUser findById(Long id) {
        SysUser user = baseMapper.selectOne(new MPJLambdaWrapper<SysUser>().eq(SysUser::getUserId, id));
        findRole(user);
        return user;
//        return sysUserMapper.findById(id);
    }

    @Override
    public SysUser findByName(String userName) {
        SysUser user = baseMapper.selectOne(new MPJLambdaWrapper<SysUser>().eq(SysUser::getUserName, userName));
        findRole(user);
        return user;
//        return sysUserMapper.findByName(userName);
    }

    /**
     * 处理注册逻辑
     * @param sysUser
     * @return
     */
    @Override
    public int add(SysUser sysUser) {
        if(!isUserNameUnique(sysUser.getUserName(), -1L)){
            throw new AuthenticationException("用户名重复");
        }
        //处理密码：md5 + salt + hash散列
        String salt = SaltUtils.getSalt(8);
        Md5Hash md5Hash = new Md5Hash(sysUser.getPassword(), salt, 1024);

        sysUser.setPassword(md5Hash.toHex());
        sysUser.setSalt(salt);
        return baseMapper.insert(sysUser);
//        return sysUserMapper.add(sysUser);
    }

    @Override
    public int update(SysUser sysUser) {
        if(!isUserNameUnique(sysUser.getUserName(), sysUser.getUserId())){
            throw new AuthenticationException("用户名重复");
        }
        SysUser originUser = sysUserMapper.findById(sysUser.getUserId());
        if(originUser == null){
            throw new AuthenticationException("用户不存在");
        }

        if(!originUser.getPassword().equals(sysUser.getPassword())){
            //修改了密码
            //重新处理密码存储
            String salt = SaltUtils.getSalt(8);
            Md5Hash md5Hash = new Md5Hash(sysUser.getPassword(), salt, 1024);

            sysUser.setPassword(md5Hash.toHex());
            sysUser.setSalt(salt);
        }
        return baseMapper.updateById(sysUser);
//        return sysUserMapper.update(sysUser);
    }

    @Override
    public int delete(Long[] ids) {
//        int rows = 0;
//        for (Long id : ids) {
//            rows += sysUserMapper.delete(id);
//        }
//        return rows;
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public LoginUser login(SysUserVo sysUserVo) {
        //登录，先查询用户信息
//        SysUser user = sysUserMapper.findByName(sysUserVo.getUserName());
        SysUser user = baseMapper.selectOne(new MPJLambdaWrapper<SysUser>()
                .eq(SysUser::getUserName, sysUserVo.getUserName()));
        if(user == null){
            throw new AuthenticationException("用户名不存在");
        }

        //验证密码
        Md5Hash md5Hash = new Md5Hash(sysUserVo.getPassword(), user.getSalt(), 1024);
        if(!user.getPassword().equals(md5Hash.toHex())){
            throw new AuthenticationException("用户名或密码错误");
        }

        //设置登录用户对象
        LoginUser loginUser = findLoginUser(sysUserVo);

        //颁发token
        String token = JwtUtil.sign(user.getUserName(), user.getPassword());
        loginUser.setToken(token);
        return loginUser;
    }


    @Override
    public LoginUser findLoginUser(SysUserVo sysUserVo) {
        return sysUserMapper.findLoginUser(sysUserVo);
    }

    @Override
    public boolean isUserNameUnique(String userName, Long userId) {
        List<Long> userIds = sysUserMapper.findUsersByName(userName);
        for(Long id : userIds){
            if(id.equals(userId)){
                return true;
            }
        }
        return userIds.isEmpty();
    }
}
