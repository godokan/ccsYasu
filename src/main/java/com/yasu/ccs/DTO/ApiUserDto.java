package com.yasu.ccs.DTO;

import com.yasu.ccs.Domain.Entity.ApiUserEntity;
import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class ApiUserDto {
    @NonNull
    private Integer no;
    private String api_key;
    private Integer stud_num;

    @Builder
    public ApiUserDto(@NonNull Integer no, String api_key, Integer stud_num) {
        this.no = no;
        this.api_key = api_key;
        this.stud_num = stud_num;
    }

    public ApiUserEntity toEntity() {
        return ApiUserEntity.builder()
                .no(no)
                .apiKey(api_key)
                .studNum(CcsUserEntity.builder().studNum(this.stud_num).build())
                .build();
    }
}
