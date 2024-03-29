package com.gouyan.system.domin.vo;

import com.gouyan.system.domin.SysBill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Aixchen
 * @date 2024/1/24 17:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysBillVo implements Serializable {

    //订单信息
    private SysBill sysBill;

    //若成功更新后场次的座位信息
    private String sessionSeats;

}
