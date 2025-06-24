package com.kalpa.video.service;

import com.kalpa.video.model.PetsDTO;

import java.util.List;

public interface PetsService {
    
    /**
     * 获取所有宠物列表
     */
    List<PetsDTO> getAll();
    
    /**
     * 根据ID获取宠物详情
     */
    PetsDTO getById(Long id);
    
    /**
     * 创建新宠物
     */
    Boolean create(PetsDTO petsDTO);
    
    /**
     * 更新宠物信息
     */
    Boolean updateById(Long id, PetsDTO petsDTO);
    
    /**
     * 删除宠物
     */
    Boolean deleteById(Long id);
}