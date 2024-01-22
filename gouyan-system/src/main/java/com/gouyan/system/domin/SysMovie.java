package com.gouyan.system.domin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 14:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysMovie implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "movie_id",type = IdType.AUTO)
    private Long movieId;

    //电影中文名
    @NotBlank(message = "电影中文名不能为空")
    @TableField("movie_name_cn")
    private String movieNameCn;

    //电影英文名
    @NotBlank(message = "电影英文名不能为空")
    @TableField("movie_name_en")
    private String movieNameEn;

    //电影时长
    @TableField("movie_length")
    private Integer movieLength;

    //电影海报
    @TableField("movie_poster")
    private String moviePoster;

    //电影区域id
    @TableField("movie_area_id")
    private Long movieAreaId;

    //电影年代id
    @TableField("movie_age_id")
    private Long movieAgeId;

    //上映日期
    @TableField("release_date")
    private Date releaseDate;

    //电影评分
    @TableField("movie_score")
    private Double movieScore;

    //电影总票房
    @TableField("movie_box_office")
    private Double movieBoxOffice;

    //评分人数
    @TableField("movie_rate_num")
    private Integer movieRateNum;

    //电影简介
    @TableField("movie_introduction")
    private String movieIntroduction;

    //电影图集
    @TableField("movie_pictures")
    private String moviePictures;


    //电影区域
    @TableField(exist = false)
    private SysMovieArea sysMovieArea;

    //电影年代
    @TableField(exist = false)
    private SysMovieAge sysMovieAge;


    //电影的参演人员角色，每个角色分别对应若干演员
    @TableField(exist = false)
    private List<SysActorRole> actorRoleList;

    //影评列表
    @TableField(exist = false)
    private List<SysMovieComment> movieCommentList;

    //电影的类别
    @TableField(exist = false)
    private List<SysMovieCategory> movieCategoryList;

    //电影主演名称，在影院中显示
    @TableField(exist = false)
    private List<String> majorActorNameList;

}
