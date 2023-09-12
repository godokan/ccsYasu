package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class ApiListDto {
    @NonNull
    Integer no;
    String name;
    String description;
    String id;
}
