package com.gouyan.system.domin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Aixchen
 * @date 2024/1/24 17:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysMovieVo {

    private String movieNameCn;

    private String movieNameEn;

    private Long movieAreaId;

    private Long movieAgeId;

    private Long movieCategoryId;

    private Date startDate;

    private Date endDate;

}
