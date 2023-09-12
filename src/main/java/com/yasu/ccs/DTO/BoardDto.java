package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class BoardDto {
    int no;
    int stud_num;
    String context;

    public void setStud_num(int stud_num) {
        this.stud_num = stud_num;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
