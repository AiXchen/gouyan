package com.gouyan.system.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lxd
 * @create 2020-11-19 18:32
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SysMovieCategory {
    //序列号
    private static final long serialVersionUID = 1L;
    //电影分类id
    private Long movieCategoryId;
    //电影分类名称
    private String movieCategoryName;
}
