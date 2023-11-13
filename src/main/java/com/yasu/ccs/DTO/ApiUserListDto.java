package com.yasu.ccs.DTO;

import com.yasu.ccs.Domain.Entity.ApiUserListEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class ApiUserListDto {

    private Integer no;
    private Integer listName;
    private Integer userStudNum;
    private String apiKey;

    @Builder
    public ApiUserListDto(Integer no, Integer listName, Integer userStudNum, String apiKey) {
        this.no = no;
        this.listName = listName;
        this.userStudNum = userStudNum;
        this.apiKey = apiKey;
    }

    public ApiUserListEntity toEntity() {
        return ApiUserListEntity.builder()
                .no(no)
                .listName(listName)
                .userStudNum(userStudNum)
                .apiKey(apiKey)
                .build();
    }
}
