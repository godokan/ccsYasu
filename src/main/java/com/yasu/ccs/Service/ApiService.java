package com.yasu.ccs.Service;

import com.yasu.ccs.DTO.ApiListDto;
import com.yasu.ccs.DTO.CcsUserDto;
import com.yasu.ccs.Domain.Entity.ApiListEntity;
import com.yasu.ccs.Domain.Entity.ApiUserListEntity;
import com.yasu.ccs.Domain.Repository.ApiListRepository;
import com.yasu.ccs.Domain.Repository.ApiUserListRepository;
import com.yasu.ccs.Domain.Repository.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    private RestTemplate restTemplate = new RestTemplate();

    public List<ApiListDto> getApiList() {
        List<ApiListEntity> entities = listRepository.findAll();
        List<ApiListDto> dtoList = new ArrayList<>();
        entities.forEach(entity -> dtoList.add(entity.toDto()));
        return dtoList;
    }

    public ApiListDto getApiById(String apiId) {
        ApiListEntity entity = listRepository.findById(apiId);
        return entity.toDto();
    }

    public ApiListDto getApiByName(String name) {
        ApiListEntity entity = listRepository.findByName(name);
        return entity.toDto();
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

    // API 통신부

    public String getApiUser(Integer studNum) {
        final String URL = "http://localhost:81/api/user/findUser?studNum="+studNum;
        return restTemplate.getForObject(URL, String.class);
    }

    public String signUp(Integer studNum, String id) {
        final String URL = "http://localhost:81/api/user/signup?studNum="+studNum+"&id="+id;
        return restTemplate.getForObject(URL, String.class);
    }

    public String issueApiKey(CcsUserDto user, String id) {
        final String URL = "http://localhost:81/api/user/issue?id="+user.getId()+"&studNum="+user.getStudNum()+"&apiId="+id;
        String result = restTemplate.getForObject(URL, String.class);
        // TODO: 후에 추가될 에러 처리에 맞춰 switch-case 만들기
        return result;
    }

    public String getKey(Integer studNum, String listName){
        final String URL = "http://localhost:81/api/user/getKey?studNum="+studNum+"&listName="+listName;
        return restTemplate.getForObject(URL, String.class);
    }
}
