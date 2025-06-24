package com.kalpa.video.repository;

import com.kalpa.video.repository.po.Pets;
import com.kalpa.video.repository.mapper.PetsMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Repository;

/**
 * <p>
 * 宠物表 仓储类
 * </p>
 *
 * @author mybatisplus-generator
 * @since 2025-06-05
 */

@Repository
public class PetsRepository extends ServiceImpl<PetsMapper, Pets> {

}