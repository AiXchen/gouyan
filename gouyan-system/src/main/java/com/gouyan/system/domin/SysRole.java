package com.gouyan.system.domin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/23 10:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysRole implements Serializable {

    private static final Long serialVersionUID = 1L;

    @TableId(value = "role_id",type = IdType.AUTO)
    private Long roleId;

    //角色名称
    @NotBlank(message = "角色名称不能为空")
    @TableField("role_name")
    private String roleName;

    //角色描述
    @NotBlank(message = "角色描述不能为空")
    @TableField("role_desc")
    private String roleDesc;

    //角色拥有的权限，分多级权限存储，取名为children方便读取所有权限
    @TableField(exist = false)
    private List<SysResource> children;
}
