package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class ApiUserDto {
    @NonNull
    Integer no;
    String api_key;
    Integer stud_num;
}
