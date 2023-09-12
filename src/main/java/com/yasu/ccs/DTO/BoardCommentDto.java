package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class BoardCommentDto {
    @NonNull
    Integer no;
    Integer board_no;
    String context;
}
