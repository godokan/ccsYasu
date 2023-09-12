package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class BoardDto {
    @NonNull
    Integer no;
    Integer stud_num;
    String context;
}
