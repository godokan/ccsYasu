package com.yasu.ccs.DTO;

import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserDto {
    @NonNull
    private Integer studNum;
    private String id;
    private String pw;
    private String name;

    @Builder
    public UserDto(@NonNull Integer studNum, String id, String pw, String name) {
        this.studNum = studNum;
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public CcsUserEntity toEntity() {
        System.out.println("CcsUserEntity toEntity()");
        return CcsUserEntity.builder()
                .studNum(studNum)
                .id(id)
                .pw(pw)
                .name(name)
                .build();
    }
}
