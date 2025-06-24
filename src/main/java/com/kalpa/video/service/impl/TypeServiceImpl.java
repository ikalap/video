package com.kalpa.video.service.impl;

import com.kalpa.video.model.TypeDTO;
import com.kalpa.video.repository.TypeRepository;
import com.kalpa.video.service.TypeService;
import com.kalpa.video.repository.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * ${tableComment} 服务实现类
 * </p>
 *
 * @author mybatisplus-generator
 * @since 2025-06-05
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    /**
     * 获取所有Type列表
     */
    @Override
    public List<TypeDTO> getAll() {
        return typeRepository.list().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * 根据ID获取Type详情
     */
    @Override
    public TypeDTO getById(Long id) {
        return typeRepository.getOptById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    /**
     * 创建新Type
     */
    @Override
    public Boolean create(TypeDTO typeDTO) {
        Type type = convertToEntity(typeDTO);
        return typeRepository.save(type);
    }

    /**
     * 更新Type信息
     */
    @Override
    public Boolean updateById(Long id, TypeDTO typeDTO) {
        Type existingType = typeRepository.getOptById(id).orElse(null);
        if (existingType == null) {
            return false;
        }

        // 更新实体属性
        BeanUtils.copyProperties(typeDTO, existingType);
        return typeRepository.updateById(existingType);
    }

    /**
     * 删除Type
     */
    @Override
    public Boolean deleteById(Long id) {
        return typeRepository.removeById(id);
    }

    /**
     * 将PO对象转换为DTO对象
     */
    private TypeDTO convertToDTO(Type type) {
        TypeDTO dto = new TypeDTO();
        BeanUtils.copyProperties(dto, type);
        return dto;
    }

    /**
     * 将DTO对象转换为PO实体
     */
    private Type convertToEntity(TypeDTO typeDTO) {
        Type type = new Type();
        BeanUtils.copyProperties(type, typeDTO);
        return type;
    }
}