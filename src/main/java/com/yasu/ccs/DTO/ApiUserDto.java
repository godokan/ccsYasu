package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class ApiUserDto {
    @NonNull
    private Integer no;
    private String api_key;
    private Integer stud_num;
}
