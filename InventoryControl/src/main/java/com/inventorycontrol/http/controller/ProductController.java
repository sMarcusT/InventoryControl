package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.controller.interfaces.IProductController;
import com.inventorycontrol.http.dto.request.ProductRequest;
import com.inventorycontrol.http.dto.response.ProductResponse;
import com.inventorycontrol.http.mapper.ProductMapper;
import com.inventorycontrol.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController implements IProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok().body(ProductMapper.toResponseList(productService.findAll()));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findById(@PathVariable String productId) {
        return ResponseEntity.ok().body(ProductMapper.toResponse(productService.findById(UUID.fromString(productId))));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.ok().body(ProductMapper.toResponse(productService.save(ProductMapper.toModel(productRequest))));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> update(@RequestBody @Valid ProductRequest productRequest, @PathVariable String productId) {
        return ResponseEntity.ok().body(ProductMapper.toResponse(productService.update(ProductMapper.toModel(productRequest), UUID.fromString(productId))));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<UUID> delete(@PathVariable String productId) {
        return ResponseEntity.ok().body(productService.delete(UUID.fromString(productId)));
    }
}