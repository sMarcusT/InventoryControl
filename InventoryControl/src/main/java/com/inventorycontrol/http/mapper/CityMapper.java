package com.inventorycontrol.http.mapper;

import com.inventorycontrol.http.dto.request.CityRequest;
import com.inventorycontrol.http.dto.response.CityResponse;
import com.inventorycontrol.model.CityModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class CityMapper {

    public static CityModel toModel(CityRequest cityRequest) {
        return CityModel.builder()
                .cityName(cityRequest.getCityName())
                .uf(cityRequest.getUf())
                .build();
    }

    public static CityResponse toResponse(CityModel cityModel) {
        return CityResponse.builder()
                .cityId(cityModel.getCityId())
                .cityName(cityModel.getCityName())
                .uf(cityModel.getUf())
                .build();
    }

    public static List<CityResponse> responseList(List<CityModel> cityModelList) {
        if (isNull(cityModelList) || cityModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return cityModelList.stream().map(CityMapper::toResponse).collect(Collectors.toList());
        }
    }
}
