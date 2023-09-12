package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ApiUserDto {
    int no;
    String api_key;
    int stud_num;

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public void setStud_num(int stud_num) {
        this.stud_num = stud_num;
    }
}
