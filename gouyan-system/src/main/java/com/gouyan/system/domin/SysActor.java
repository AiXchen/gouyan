package com.gouyan.system.domin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author lxd
 * @create 2020-11-23 14:54
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysActor implements Serializable {

    private static final Long serialVersionUID = 1L;

    //演员id
    @TableId(value = "actor_id",type = IdType.ASSIGN_ID)
    private Long actorId;

    //演员名
    @NotBlank(message = "演员名不能为空")
    @TableField("actor_name")
    private String actorName;

    //演员图片
//    @NotBlank(message = "演员图片不能为空")
    @TableField("actor_photo")
    private String actorPhoto;

    //演员身高
    @Range(min = 100, max = 300, message = "身高需要在1m到3m之间")
    @TableField("actor_height")
    private Double actorHeight;

    @Min(value = 0, message = "年龄不得低于0")
    @Max(value = 100, message = "年龄不得高于100")
    @TableField("actor_age")
    //演员年龄
    private Integer actorAge;

    @NotNull(message = "性别不能为空")
    @TableField("actor_gender")
    //演员性别
    private Boolean actorGender;

//    @NotBlank(message = "毕业院校不得为空")
    //演员毕业院校
    @TableField("actor_school")
    private String actorSchool;

    //演员民族
    @TableField("actor_nation")
    private String actorNation;

    //演员血型
    @TableField("actor_blood_type")
    private String actorBloodType;

    //演员星座
    @TableField("actor_constellation")
    private String actorConstellation;

    //演员国籍
    @TableField("actor_nationality")
    private String actorNationality;

    //演员详细信息
    @TableField("actor_information")
    private String actorInformation;

    @TableField(exist = false)
    private List<SysMovie> movieList;

    @TableField(exist = false)
    private List<SysActorRole> actorRoleList;

}
