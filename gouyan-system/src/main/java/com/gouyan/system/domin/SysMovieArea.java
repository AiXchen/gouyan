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
 * @date 2024/1/22 15:17
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysMovieArea implements Serializable {

    //序列号
    private static final long serialVersionUID = 1L;

    //电影区域id
    @TableId(value = "movie_area_id",type = IdType.AUTO)
    private Long movieAreaId;

    //电影区域名称
    @NotBlank(message = "电影区域名称不能为空")
    @TableField("movie_area_name")
    private String movieAreaName;
}
