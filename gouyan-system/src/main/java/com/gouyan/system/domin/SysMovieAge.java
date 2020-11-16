package com.gouyan.system.domin;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 电影年代
 * @Author: 华雨欣
 * @Create: 2020-11-14 22:46
 */
public class SysMovieAge implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long movieAgeId;//年代id

    @NotEmpty(message = "年代名称不能为空")
    private String movieAgeName;//年代名称

    public Long getMovieAgeId() {
        return movieAgeId;
    }

    public void setMovieAgeId(Long movieAgeId) {
        this.movieAgeId = movieAgeId;
    }

    public String getMovieAgeName() {
        return movieAgeName;
    }

    public void setMovieAgeName(String movieAgeName) {
        this.movieAgeName = movieAgeName;
    }

    @Override
    public String toString() {
        return "sysMovieAge{" +
                "movieAgeId=" + movieAgeId +
                ", movieAgeName='" + movieAgeName + '\'' +
                '}';
    }
}