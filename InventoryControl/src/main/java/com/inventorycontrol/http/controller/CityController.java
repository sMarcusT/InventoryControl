package com.inventorycontrol.http.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventorycontrol.http.controller.interfaces.ICityController;
import com.inventorycontrol.http.dto.request.CityRequest;
import com.inventorycontrol.http.dto.response.CityResponse;
import com.inventorycontrol.http.mapper.CityMapper;
import com.inventorycontrol.service.CityService;

import lombok.AllArgsConstructor;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/city")
public class CityController implements ICityController {

    private final CityService cityService;

    @GetMapping("/all")
    public ResponseEntity<List<CityResponse>> findAll() {
        return ResponseEntity.ok().body(CityMapper.toResponseList(cityService.findAll()));
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityResponse> findById(@PathVariable String cityId) {
        return ResponseEntity.ok().body(CityMapper.toResponse(cityService.findById(UUID.fromString(cityId))));
    }

    @PostMapping
    public ResponseEntity<CityResponse> save(@RequestBody @Valid CityRequest cityRequest) {
        return ResponseEntity.ok().body(CityMapper.toResponse(cityService.save(CityMapper.toModel(cityRequest))));
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<CityResponse> update(@RequestBody @Valid CityRequest cityRequest,
            @PathVariable String cityId) {
        return ResponseEntity.ok().body(
                CityMapper.toResponse(cityService.update(CityMapper.toModel(cityRequest), UUID.fromString(cityId))));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<UUID> delete(@PathVariable String clientId) {
        return ResponseEntity.ok().body(cityService.delete(UUID.fromString(clientId)));
    }
}
