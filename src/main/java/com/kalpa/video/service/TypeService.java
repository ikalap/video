package com.kalpa.video.service;

import com.kalpa.video.model.TypeDTO;

import java.util.List;

/**
 * <p>
 * ${tableComment} 服务接口
 * </p>
 *
 * @author mybatisplus-generator
 * @since 2025-06-05
 */
public interface TypeService {
    
    /**
     * 获取所有Type列表
     */
    List<TypeDTO> getAll();
    
    /**
     * 根据ID获取Type详情
     */
    TypeDTO getById(Long id);
    
    /**
     * 创建新Type
     */
    Boolean create(TypeDTO dto);

    /**
     * 更新Type信息
     */
    Boolean updateById(Long id, TypeDTO dto);
    
    /**
     * 删除Type
     */
    Boolean deleteById(Long id);
}