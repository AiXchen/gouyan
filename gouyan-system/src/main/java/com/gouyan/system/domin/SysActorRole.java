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
 * @date 2024/1/24 17:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysActorRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "actor_role_id",type = IdType.ASSIGN_ID)
    private Long actorRoleId;

    @NotBlank(message = "演员角色名称不能为空")
    @TableField(value = "actor_role_name")
    private String actorRoleName;

    //多表连接
    @TableField(exist = false)
    private List<SysActor> actorList;
}
