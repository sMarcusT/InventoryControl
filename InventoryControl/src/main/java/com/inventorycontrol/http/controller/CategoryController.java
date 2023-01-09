package com.inventorycontrol.http.controller;

import com.inventorycontrol.http.controller.interfaces.ICategoryController;
import com.inventorycontrol.http.dto.message.MessageError;
import com.inventorycontrol.http.dto.request.CategoryRequest;
import com.inventorycontrol.http.dto.response.CategoryResponse;
import com.inventorycontrol.http.mapper.CategoryMapper;
import com.inventorycontrol.service.impl.CategorySeviceImpl;
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
@RequestMapping("/category")
public class CategoryController implements ICategoryController {

    private final CategorySeviceImpl categoryServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> findAll() {
        return ResponseEntity.ok().body(CategoryMapper.toResponseList(categoryServiceImpl.findAll()));
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable String categoryId) {
        return ResponseEntity.ok()
                .body(CategoryMapper.toResponse(categoryServiceImpl.findById(UUID.fromString(categoryId))));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@RequestBody @Valid CategoryRequest categoryRequest) {
        return ResponseEntity.ok()
                .body(CategoryMapper.toResponse(categoryServiceImpl.save(CategoryMapper.toModel(categoryRequest))));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> update(@RequestBody @Valid CategoryRequest categoryRequest,
                                                   @PathVariable String categoryId) {
        return ResponseEntity.ok().body(CategoryMapper.toResponse(
                categoryServiceImpl.update(CategoryMapper.toModel(categoryRequest), UUID.fromString(categoryId))));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<MessageError> delete(@PathVariable String categoryId) {
        categoryServiceImpl.delete(UUID.fromString(categoryId));
        var messageError = new MessageError();
        messageError.setMessage("Categoria deletada com sucesso!");
        messageError.setStatusCode(200);
        return ResponseEntity.ok().body(messageError);
    }
}
