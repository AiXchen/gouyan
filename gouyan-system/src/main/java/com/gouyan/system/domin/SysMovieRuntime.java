package com.gouyan.system.domin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author Aixchen
 * @date 2024/1/22 17:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysMovieRuntime implements Serializable {

    private static final Long serialVersionUID = 1L;

    @TableId(value = "movie_runtime_id",type = IdType.AUTO)
    private Long movieRuntimeId;

    //播放时段名称
    @NotBlank(message = "播放时段名称不能为空")
    @TableField("movie_runtime_name")
    private String movieRuntimeName;

    //时段开始时间
    @NotBlank(message = "时段开始时间不能为空")
    @Pattern(regexp = "^(20|21|22|23|[0-1]\\d):[0-5]\\d$", message = "时间输入格式不匹配，请按照：hh:mm 输入")
    @TableField("begin_time")
    private String beginTime;

    //时段结束时间
    @NotBlank(message = "时段结束时间不能为空")
    @Pattern(regexp = "^(20|21|22|23|[0-1]\\d):[0-5]\\d$", message = "时间输入格式不匹配，请按照：hh:mm 输入")
    @TableField("end_time")
    private String endTime;

}
