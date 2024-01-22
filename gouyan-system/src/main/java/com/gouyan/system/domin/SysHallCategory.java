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
 * @date 2024/1/22 14:10
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysHallCategory implements Serializable{
    //序列号
    private static final long serialVersionUID = 1L;

    //影厅分类id
    @TableId(value = "hall_category_id",type = IdType.AUTO)
    private Long hallCategoryId;

    //影厅分类名称
    @NotBlank(message = "影厅分类名称不能为空")
    @TableField("hall_category_name")
    private String hallCategoryName;
}
