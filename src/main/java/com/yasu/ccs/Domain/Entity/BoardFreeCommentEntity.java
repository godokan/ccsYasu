package com.yasu.ccs.Domain.Entity;

import com.yasu.ccs.DTO.BoardCommentDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board_free_comment", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardFreeCommentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private Integer no;

    @JoinColumn(name = "board_no", referencedColumnName = "no", insertable = false, updatable = false)
    private Integer boardNo;

    @Column(name = "context", nullable = false, length = 2000)
    private String context;

    @Builder
    public BoardFreeCommentEntity(Integer no, Integer boardNo, String context) {
        this.no = no;
        this.boardNo = boardNo;
        this.context = context;
    }

    public BoardCommentDto toDto() {
        return BoardCommentDto.builder()
                .no(no)
                .board_no(boardNo)
                .context(context)
                .build();
    }
}
