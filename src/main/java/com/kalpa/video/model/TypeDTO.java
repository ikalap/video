package com.kalpa.video.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 类型表
 * </p>
 *
 * @author mybatisplus-generator
 * @since 2025-06-05
 */
@Getter
@Setter
@Accessors(chain = true)
public class TypeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 父类型id
     */
    private Long parentId;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型图标
     */
    private String typeIcon;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updateAt;
}
