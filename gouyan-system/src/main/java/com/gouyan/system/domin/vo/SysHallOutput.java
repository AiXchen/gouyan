package com.gouyan.system.domin.vo;

import com.gouyan.system.domin.SysCinema;
import com.gouyan.system.domin.SysHallCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: sysHallOutput
 * @Author xchen
 * @Date: 2024/1/22 14:24
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysHallOutput {

    private Long cinemaId;

    private Long hallId;

    private Long hallCategoryId;

    private SysCinema sysCinema;

    private SysHallCategory sysHallCategory;


}
