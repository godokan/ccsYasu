package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserDto {
    private int stud_num;
    private String id;
    private String pw;
    private String name;

    public void setStud_num(int stud_num) {
        this.stud_num = stud_num;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }
}
