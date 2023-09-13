package com.yasu.ccs.Domain.Entity;

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

    @ManyToOne(cascade = CascadeType.REMOVE, targetEntity = BoardFreeEntity.class)
    @JoinColumn(name = "board_no", referencedColumnName = "no", insertable = false, updatable = false)
    private BoardFreeEntity boardNo;

    @Column(name = "context", nullable = false, length = 2000)
    private String context;

    @Builder
    public BoardFreeCommentEntity(Integer no, BoardFreeEntity boardNo, String context) {
        this.no = no;
        this.boardNo = boardNo;
        this.context = context;
    }
}
