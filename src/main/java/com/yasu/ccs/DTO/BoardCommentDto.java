package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class BoardCommentDto {
    @NonNull
    private Integer no;
    private Integer board_no;
    private String context;
}
