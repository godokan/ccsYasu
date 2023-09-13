package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class BoardDto {
    @NonNull
    private Integer no;
    private Integer stud_num;
    private String context;
}
