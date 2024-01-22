package com.gouyan.system.domin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Aixchen
 * @date 2024/1/22 17:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysMovieToCategory implements Serializable {

    private static final Long serialVersionUID = 1L;

    @TableField("movie_id")
    private Long movieId;

    @TableField("movie_category_id")
    private Long movieCategoryId;
}
