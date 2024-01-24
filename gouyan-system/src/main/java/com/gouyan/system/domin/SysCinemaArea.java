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
 * @date 2024/1/24 17:41
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SysCinemaArea implements Serializable {

    private static final Long serialVersionUID = 1L;

    //影院区域id
    @TableId(value = "cinema_area_id",type = IdType.AUTO)
    private Long cinemaAreaId;

    //影院区域名称
    @NotBlank(message = "影院区域名称不能为空")
    @TableField("cinema_area_name")
    private String cinemaAreaName;

    //影院所属省份
    @NotBlank(message = "影院所属省份不能为空")
    @TableField("province")
    private String province;

    //影院所属城市
    @NotBlank(message = "影院所属城市不能为空")
    @TableField("city")
    private String city;

}
