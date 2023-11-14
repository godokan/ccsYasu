package com.yasu.ccs.DTO;

import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class CcsUserDto {
    private Integer no;
    private Integer studNum;
    private String id;
    private String pw;
    private String name;

    @Builder
    public CcsUserDto(Integer no, Integer studNum, String id, String pw, String name) {
        this.no = no;
        this.studNum = studNum;
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public CcsUserEntity toEntity() {
        return CcsUserEntity.builder()
                .no(no)
                .studNum(studNum)
                .id(id)
                .pw(pw)
                .name(name)
                .build();
    }
}
