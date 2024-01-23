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
 * @date 2024/1/23 9:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysResource implements Serializable {

    private static final Long serialVersionUID = 1L;

    @TableId(value = "resource_id",type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "菜单名称不能为空")
    @TableField("resource_name")
    private String name;

    @TableField("path")
    private String path;

    //菜单权限等级
    @TableField("level")
    private Integer level;

    @TableField("parent_id")
    private Long parentId;

    //父菜单
    @TableField(exist = false)
    private SysResource parent;

    //子菜单
    @TableField(exist = false)
    private List<SysResource> children;

}
