package com.gouyan.system.domin;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysUserHobby implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long userHobbyId;

    @NotBlank(message = "爱好名称不能为空")
    private String userHobbyName;

}