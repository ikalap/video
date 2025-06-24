package com.kalpa.video.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
@Schema(description = "宠物DTO")
public class PetsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "宠物ID", example = "1")
    private Integer id;

    /**
     * 宠物名称
     */
    @Schema(description = "宠物名称")
    private String name;

    /**
     * 宠物物种: 猫，狗等
     */
    private String species;

    /**
     * 宠物品种: 银渐层，边牧等
     */
    private String variety;

    /**
     * 性别：0男 1女
     */
    private Integer gender;

    /**
     * 生日
     */
    private LocalDate birthDate;

    /**
     * 主人id
     */
    private Integer ownerId;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updateAt;
}
