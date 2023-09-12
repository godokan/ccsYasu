package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class BoardCommentDto {

    int no;
    int board_no;
    String context;

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
