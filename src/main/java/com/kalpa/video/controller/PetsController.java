package com.kalpa.video.controller;

import com.kalpa.video.model.PetsDTO;
import com.kalpa.video.service.PetsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

/**
 * <p>
 * 宠物表 前端控制器
 * </p>
 *
 * @author mybatisplus-generator
 * @since 2025-06-05
 */
@RestController
@RequestMapping("/api/pets")
@Tag(name = "宠物管理")
public class PetsController {

    @Autowired
    private PetsService petsService;

    @GetMapping("/api/v1/query")
    public String query() {
        return "Query endpoint";
    }

    @GetMapping
    @Operation(summary = "获取所有宠物列表")
    public ResponseEntity<List<PetsDTO>> getAllPets() {
        List<PetsDTO> petsList = petsService.getAll();
        return ResponseEntity.ok(petsList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID获取宠物详情", parameters = {@Parameter(description = "宠物ID")})
    public ResponseEntity<PetsDTO> getPetById(@PathVariable Long id) {
        return ResponseEntity.ok(petsService.getById(id));
    }

    @PostMapping
    @Operation(summary = "创建新宠物")
    public ResponseEntity<Boolean> createPet(@RequestBody PetsDTO petsDTO) {
        return ResponseEntity.ok(petsService.create(petsDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新宠物信息")
    public ResponseEntity<Boolean> updatePet(@PathVariable Long id, @RequestBody PetsDTO petsDTO) {
        return ResponseEntity.ok(petsService.updateById(id, petsDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除宠物")
    public ResponseEntity<Boolean> deletePet(@PathVariable Long id) {
        return ResponseEntity.ok(petsService.deleteById(id));
    }

}
