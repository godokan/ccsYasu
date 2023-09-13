package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class ApiListDto {
    @NonNull
    private Integer no;
    private String name;
    private String description;
    private String id;
}
