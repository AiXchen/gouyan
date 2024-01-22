package com.gouyan.system.domin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Aixchen
 * @date 2024/1/22 15:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysMovieComment implements Serializable {

    private static final long serialVersionUID = 1L;

    //电影id
    @NotNull(message = "评论的电影不存在")
    @TableField("movie_id")
    private Long movieId;

    //用户id
    @NotNull(message = "评论的用户不存在")
    @TableId("user_id")
    private Long userId;

    //评论时间
    @NotNull(message = "评论时间不能为空")
    @TableField("comment_time")
    private Date commentTime;

    //评论内容
    @NotBlank(message = "评论内容不能为空")
    @TableField("content")
    private String content;

    //评分
    @TableField("score")
    private Double score;


    //评论用户
    @TableField(exist = false)
    private SysUser sysUser;

    //评论的电影
    @TableField(exist = false)
    private SysMovie sysMovie;

}
