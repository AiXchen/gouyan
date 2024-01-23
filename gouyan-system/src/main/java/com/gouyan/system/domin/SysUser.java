package com.gouyan.system.domin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author Aixchen
 * @date 2024/1/22 15:51
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysUser implements Serializable {
    private final static Long serialVersionUID = 1L;

    //用户id
    @TableId(value = "user_id",type = IdType.AUTO)
    private Long userId;

    //用户名
    @TableField("user_name")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    //密码
    @TableField("password")
    @NotBlank(message = "密码不能为空")
    private String password;

    //盐
    @TableField("salt")
    private String salt;

    //邮箱
    @TableField("email")
    @Email(message = "邮箱格式有误")
    private String email;

    //电话号码
    @TableField("phone_number")
    @Pattern(regexp = "^1[3|4|5|7|8]\\d{9}$", message = "电话号码格式有错")
    private String phoneNumber;


    //性别
    @TableField("sex")
    private Boolean sex;

    //用户头像
    @TableField("user_picture")
    private String userPicture;

    //用户对应的角色id，为简化操作，采用1对1
    @TableField("role_id")
    private Long roleId;

    //用户信息
    @TableField("information")
    private String information;

    //用户的角色
    @TableField(exist = false)
    private SysRole sysRole;
}
