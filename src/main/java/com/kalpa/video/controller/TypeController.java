package com.kalpa.video.controller;

import com.kalpa.video.model.TypeDTO;
import com.kalpa.video.service.TypeService;
import io.micrometer.core.annotation.Counted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 类型表 前端控制器
 * @author mybatisplus-generator
 * @since 2025-06-06
 */
@RestController
@RequestMapping("/api/type")
@Tag(name = "类型表")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping
    @Counted
    public ResponseEntity<List<TypeDTO>> getAllType() {
        List<TypeDTO> typeList = typeService.getAll();
        return ResponseEntity.ok(typeList);
    }

    @Operation(summary = "根据ID获取Type详情")
    @GetMapping("/{id}")
    public ResponseEntity<TypeDTO> getTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(typeService.getById(id));
    }

    @PostMapping
    @Operation(summary = "创建新Type")
    public ResponseEntity<Boolean> createType(@RequestBody TypeDTO typeDTO) {
        return ResponseEntity.ok(typeService.create(typeDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新Type信息")
    public ResponseEntity<Boolean> updateType(@PathVariable Long id, @RequestBody TypeDTO typeDTO) {
        return ResponseEntity.ok(typeService.updateById(id, typeDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除Type")
    public ResponseEntity<Boolean> deleteType(@PathVariable Long id) {
        return ResponseEntity.ok(typeService.deleteById(id));
    }

}