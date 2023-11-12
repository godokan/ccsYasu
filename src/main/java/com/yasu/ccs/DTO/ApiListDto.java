package com.yasu.ccs.DTO;

import com.yasu.ccs.Domain.Entity.ApiListEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class ApiListDto {
    private Integer no;
    private String name;
    private String description;
    private String id;

    @Builder
    public ApiListDto(Integer no, String name, String description, String id) {
        this.no = no;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public ApiListEntity toEntity() {
        return ApiListEntity.builder()
                .no(no)
                .name(name)
                .description(description)
                .id(id)
                .build();
    }
}
