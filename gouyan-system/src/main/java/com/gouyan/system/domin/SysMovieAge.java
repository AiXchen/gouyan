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

/**
 * @author Aixchen
 * @date 2024/1/22 15:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysMovieAge implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "movie_age_id",type = IdType.AUTO)
    private Long movieAgeId;//年代id

    @NotBlank(message = "年代名称不能为空")
    @TableField("movie_age_name")
    private String movieAgeName;//年代名称
}
