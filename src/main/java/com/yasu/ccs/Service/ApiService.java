package com.yasu.ccs.Service;

import com.yasu.ccs.DTO.ApiListDto;
import com.yasu.ccs.Domain.Entity.ApiListEntity;
import com.yasu.ccs.Domain.Entity.ApiUserListEntity;
import com.yasu.ccs.Domain.Repository.ApiListRepository;
import com.yasu.ccs.Domain.Repository.ApiUserListRepository;
import com.yasu.ccs.Domain.Repository.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {
    @Autowired
    ApiListRepository listRepository;
    @Autowired
    ApiUserRepository userRepository;
    @Autowired
    ApiUserListRepository userListRepository;

    public List<ApiListDto> getApiList() {
        List<ApiListEntity> entities = listRepository.findAll();
        List<ApiListDto> dtoList = new ArrayList<>();
        entities.forEach(entity -> dtoList.add(entity.toDto()));
        return dtoList;
    }

    public ApiListDto getApi(String apiName) {
        return listRepository.findByName(apiName).toDto();
    }

    public List<ApiListDto> getUserApiList(Integer studNum) {
        List<ApiUserListEntity> entities = userListRepository.findApiUserListEntitiesByUserStudNum(studNum);
        List<String > listNames = new ArrayList<>();
        List<ApiListEntity> apiListEntities = new ArrayList<>();
        List<ApiListDto> dtos = new ArrayList<>();

        if (entities.isEmpty()) {
            dtos.add(ApiListDto.builder()
                            .no(0)
                            .name("조회 된 API가 없습니다.")
                            .description("API를 신청해주시기 바랍니다.")
                            .id("404 Not Found")
                    .build());
            return dtos;
        }

        entities.forEach(entity -> listNames.add(entity.getListName()));
        listNames.forEach(listName -> apiListEntities.add(listRepository.findByName(listName)));

        apiListEntities.forEach( entity -> {
            if (entity != null)
                dtos.add(entity.toDto());
        });
        return dtos;
    }

    public String getApiUser(Integer studNum) {
        final String URL = "http://localhost:81/api/user/findUser?studNum="+studNum;

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(URL, String.class);
    }
}
