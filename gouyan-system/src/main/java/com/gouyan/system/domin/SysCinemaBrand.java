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
 * @date 2024/1/24 17:42
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SysCinemaBrand implements Serializable {

    private static final Long serialVersionUID = 1L;

    //影院区域id
    @TableId(value = "cinema_brand_id",type = IdType.AUTO)
    private Long cinemaBrandId;

    //影院区域名称
    @NotBlank(message = "影院品牌名称不能为空")
    @TableField("cinema_brand_name")
    private String cinemaBrandName;
}
