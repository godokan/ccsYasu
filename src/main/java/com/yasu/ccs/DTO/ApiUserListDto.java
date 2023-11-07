package com.yasu.ccs.DTO;

import com.yasu.ccs.Domain.Entity.ApiUserListEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class ApiUserListDto {

    private Integer no;
    private Integer listNo;
    private Integer userStudNum;

    @Builder
    public ApiUserListDto(Integer no, Integer listNo, Integer userStudNum) {
        this.no = no;
        this.listNo = listNo;
        this.userStudNum = userStudNum;
    }

    public ApiUserListEntity toEntity() {
        return ApiUserListEntity.builder()
                .no(no)
                .listNo(listNo)
                .userStudNum(userStudNum)
                .build();
    }
}
