package com.yasu.ccs.Service;

import com.yasu.ccs.DTO.ApiListMapDto;
import com.yasu.ccs.Domain.Entity.ApiListMapEntity;
import com.yasu.ccs.Domain.Repository.ApiListMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapApiService {

    @Autowired
    private ApiListMapRepository mapRepository;

    public List<ApiListMapDto> getMapList() {
        List<ApiListMapEntity> entityList = mapRepository.findAll();
        List<ApiListMapDto> dtoList = new ArrayList<>();
        for (ApiListMapEntity entity : entityList) {
            dtoList.add(entity.toDto());
        }
        return dtoList;
    }
}
