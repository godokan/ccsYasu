package com.yasu.ccs.DTO;

import com.yasu.ccs.Domain.Entity.BoardFreeCommentEntity;
import com.yasu.ccs.Domain.Entity.BoardFreeEntity;
import lombok.*;

import javax.xml.stream.events.Comment;

@Data
public class BoardCommentDto {
    @NonNull
    private Integer no;
    private Integer board_no;
    private String context;
    private String date;

    @Builder
    public BoardCommentDto(@NonNull Integer no, Integer board_no, String context, String date) {
        this.no = no;
        this.board_no = board_no;
        this.context = context;
        this.date = date;
    }

    public static BoardCommentDto createBoardCommentDto(BoardFreeCommentEntity c) {
        return new BoardCommentDto(
            c.getNo(),
            c.getBoardNo(),
            c.getContext(),
            c.getDate()
        );
    }

    public BoardFreeCommentEntity toEntity() {
        return BoardFreeCommentEntity.builder()
                .no(no)
                .boardNo(board_no)
                .context(context)
                .date(date)
                .build();
    }
}
