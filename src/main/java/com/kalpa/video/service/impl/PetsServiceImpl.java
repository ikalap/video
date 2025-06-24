package com.kalpa.video.service.impl;

import com.kalpa.video.model.PetsDTO;
import com.kalpa.video.repository.PetsRepository;
import com.kalpa.video.repository.po.Pets;
import com.kalpa.video.service.PetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 宠物表 服务实现类
 * </p>
 *
 * @author mybatisplus-generator
 * @since 2025-06-05
 */
@Service
@Slf4j
public class PetsServiceImpl implements PetsService {

    @Autowired
    private PetsRepository petsRepository;

    /**
     * 获取所有宠物列表
     */
    @Override
    public List<PetsDTO> getAll() {
        log.info("hello");
        return petsRepository.list().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * 根据ID获取宠物详情
     */
    @Override
    public PetsDTO getById(Long id) {
        return petsRepository.getOptById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    /**
     * 创建新宠物
     */
    @Override
    public Boolean create(PetsDTO petsDTO) {
        Pets pet = convertToEntity(petsDTO);
        return petsRepository.save(pet);
    }

    /**
     * 更新宠物信息
     */
    @Override
    public Boolean updateById(Long id, PetsDTO petsDTO) {
        Pets existingPet = petsRepository.getOptById(id).orElse(null);
        if (existingPet == null) {
            return null;
        }

        // 更新实体属性
        BeanUtils.copyProperties(petsDTO, existingPet);
        return petsRepository.updateById(existingPet);
    }

    /**
     * 删除宠物
     */
    @Override
    public Boolean deleteById(Long id) {
        return petsRepository.removeById(id);
    }

    /**
     * 将PO对象转换为DTO对象
     */
    private PetsDTO convertToDTO(Pets pet) {
        PetsDTO dto = new PetsDTO();
        BeanUtils.copyProperties(dto, pet);
        return dto;
    }

    /**
     * 将DTO对象转换为PO实体
     */
    private Pets convertToEntity(PetsDTO petsDTO) {
        Pets pet = new Pets();
        BeanUtils.copyProperties(pet, petsDTO);
        return pet;
    }
}