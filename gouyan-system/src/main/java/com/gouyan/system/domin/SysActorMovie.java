package com.gouyan.system.domin;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author lxd
 * @create 2020-11-27 10:09
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysActorMovie implements Serializable {
    private static final Long SerialVersionUID = 1L;

    @TableField("movie_id")
    private Long movieId;

    @TableField("actor_id")
    private Long actorId;

    @TableField("actor_role_id")
    private Long actorRoleId;
}
