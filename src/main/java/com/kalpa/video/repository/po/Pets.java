package com.kalpa.video.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 宠物表
 * </p>
 *
 * @author mybatisplus-generator
 * @since 2025-06-05
 */
@Getter
@Setter
@ToString
@TableName("pets")
@Accessors(chain = true)
public class Pets implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 宠物名称
     */
    @TableField("name")
    private String name;

    /**
     * 宠物物种: 猫，狗等
     */
    @TableField("species")
    private String species;

    /**
     * 宠物品种: 银渐层，边牧等
     */
    @TableField("variety")
    private String variety;

    /**
     * 性别：0男 1女
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 生日
     */
    @TableField("birth_date")
    private LocalDate birthDate;

    /**
     * 主人id
     */
    @TableField("owner_id")
    private Integer ownerId;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @TableField("update_at")
    private LocalDateTime updateAt;
}
