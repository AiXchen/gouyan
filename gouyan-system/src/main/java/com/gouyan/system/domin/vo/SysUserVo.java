package com.gouyan.system.domin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Aixchen
 * @date 2024/1/24 17:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysUserVo implements Serializable {

    private String userName;
    private String password;
    //验证码
    private String checkCode;

}
