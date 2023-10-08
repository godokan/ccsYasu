package com.yasu.ccs.Controller;

import com.yasu.ccs.DTO.ApiListMapDto;
import com.yasu.ccs.Service.MapApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/map")
public class MapApiController {
    @Autowired
    MapApiService mapApiService;

    @GetMapping
    public List<ApiListMapDto> mapList() {
        return mapApiService.getMapList();
    }
}
