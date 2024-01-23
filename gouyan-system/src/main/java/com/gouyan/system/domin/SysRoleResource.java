package com.gouyan.system.domin;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: SysRoleResource
 * @Author xchen
 * @Date: 2024/1/23 10:58
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysRoleResource {

    @TableField("role_id")
    private Long roleId;

    @TableField("resource_id")
    private Long resourceId;

}
