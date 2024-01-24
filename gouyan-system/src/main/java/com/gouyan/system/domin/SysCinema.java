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
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/24 17:41
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysCinema implements Serializable {
    private final static Long serialVersionUID = 1L;

    @TableId(value = "cinema_id",type = IdType.AUTO)
    private Long cinemaId;

    @NotBlank(message = "影院名称不能为空")
    @TableField("cinema_name")
    private String cinemaName;

    @NotNull(message = "影院品牌不能为空")
    @TableField("cinema_brand_id")
    private Long cinemaBrandId;

    @TableField("cinema_picture")
    private String cinemaPicture;

    @TableField("is_ticket_changed")
    private Boolean isTicketChanged;

    @TableField("is_refunded")
    private Boolean isRefunded;

    @NotNull(message = "所属区域id不能为空")
    @TableField("cinema_area_id")
    private Long cinemaAreaId;

    @TableField("cinema_address")
    private String cinemaAddress;

    @NotNull(message = "负责人id不能为空")
    @TableField("user_id")
    private Long userId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @TableField("entry_date")
    private LocalDate entryDate;

    @TableField(exist = false)
    private SysUser user;

    @TableField(exist = false)
    private SysCinemaBrand sysCinemaBrand;

    @TableField(exist = false)
    private SysCinemaArea sysCinemaArea;

    //影院存在的影厅类别
    @TableField(exist = false)
    private List<SysHallCategory> sysHallCategoryList;

    //当前影院上映的所有电影，规则：上映的电影指包括今天在内，未来5天有安排目标影片的场次
    @TableField(exist = false)
    private List<SysMovie> sysMovieList;
}
