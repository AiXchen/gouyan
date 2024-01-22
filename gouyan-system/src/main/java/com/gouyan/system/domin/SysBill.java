package com.gouyan.system.domin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单实体类
 * @Author: 华雨欣
 * @Create: 2020-11-30 13:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysBill implements Serializable {

    private static final Long serialVersionUID = 1L;

    @TableId(value = "bill_id",type = IdType.ASSIGN_ID)
    private Long billId;

    //订单状态，0表示未支付，1表示已完成
    @TableField("bill_state")
    private Boolean billState;

    //下订单的用户id
    @NotNull(message = "下订单用户不能为空")
    @TableField("user_id")
    private Long userId;

    //订单所属的场次
    @NotNull(message = "订单所属场次不能为空")
    @TableField("session_id")
    private Long sessionId;

    //订单的座位，如：1排10号、A排5号
    @NotBlank(message = "订单所选座位不能为空")
    @TableField("seats")
    private String seats;

    @TableField("bill_date")
    private Date billDate;


    //多表连接
    @TableField(exist = false)
    private SysSession sysSession;

    @TableField(exist = false)
    private SysUser sysUser;

}
