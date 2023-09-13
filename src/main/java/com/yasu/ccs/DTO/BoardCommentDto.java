package com.yasu.ccs.DTO;

import com.yasu.ccs.Domain.Entity.BoardFreeCommentEntity;
import com.yasu.ccs.Domain.Entity.BoardFreeEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class BoardCommentDto {
    @NonNull
    private Integer no;
    private Integer board_no;
    private String context;

    @Builder
    public BoardCommentDto(@NonNull Integer no, Integer board_no, String context) {
        this.no = no;
        this.board_no = board_no;
        this.context = context;
    }

    public BoardFreeCommentEntity toEntity() {
        return BoardFreeCommentEntity.builder()
                .no(no)
                .boardNo(BoardFreeEntity.builder().no(this.board_no).build())
                .context(context)
                .build();
    }
}
