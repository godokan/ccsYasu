package com.yasu.ccs.DTO;

import com.yasu.ccs.Domain.Entity.ApiUserEntity;
import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
public class ApiUserDto {
    @NonNull
    private Integer no;
    private String api_key;
    private Integer studNum;

    @Builder
    public ApiUserDto(@NonNull Integer no, String api_key, Integer studNum) {
        this.no = no;
        this.api_key = api_key;
        this.studNum = studNum;
    }

    public ApiUserEntity toEntity() {
        return ApiUserEntity.builder()
                .no(no)
                .apiKey(api_key)
                .studNum(CcsUserEntity.builder().studNum(this.studNum).build())
                .build();
    }
}
