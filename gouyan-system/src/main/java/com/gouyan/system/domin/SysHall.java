package com.gouyan.system.domin;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Aixchen
 * @date 2024/1/22 14:49
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class SysHall implements Serializable {
    private final static Long serialVersionUID = 1L;

    @TableField("cinema_id")
    private Long cinemaId;

    @TableField("hall_id")
    private Long hallId;

    @NotBlank(message = "影厅名称不能为空")
    @TableField("hall_name")
    private String hallName;

    @NotNull(message = "影厅分类id不能为空")
    @TableField("hall_category_id")
    private Long hallCategoryId;

    //排开始标号：'1' / 'A' 等
    @TableField("row_start")
    private String rowStart;

    //影厅排数
    @Min(value = 3, message = "排数不能小于3")
    @Max(value = 50, message = "排数不能大于50")
    @TableField("row_nums")
    private Integer rowNums;

    //每排座位数
    @Min(value = 3, message = "每排座位数不能小于3")
    @Max(value = 50, message = "每排座位数不能大于50")
    @TableField("seat_nums_row")
    private Integer seatNumsRow;

    //总可用座位数，可以通过安排座位禁用指定座位
    @Min(value = 9, message = "座位数不能小于9")
    @Max(value = 2500, message = "座位数不能大于2500")
    @TableField("seat_nums")
    private Integer seatNums;

    //座位的状态，使用json存储每个座位的状态，0表示可用，2表示禁用(1表示售出，在场次表中统计)
    @TableField("seat_state")
    private String seatState;

    @NotNull(message = "影厅状态不能为空")
    @TableField("hall_state")
    private Boolean hallState;

    //影厅表的多表连接
    @TableField(exist = false)
    private SysCinema sysCinema;

    @TableField(exist = false)
    private SysHallCategory sysHallCategory;
}
