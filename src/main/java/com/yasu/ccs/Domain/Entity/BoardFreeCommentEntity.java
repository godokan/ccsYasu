package com.yasu.ccs.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "board_free_comment", schema = "ccsyasu_db", catalog = "")
public class BoardFreeCommentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private int no;
    @Basic
    @Column(name = "board_no", nullable = false)
    private int boardNo;
    @Basic
    @Column(name = "context", nullable = false, length = 2000)
    private String context;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardFreeCommentEntity that = (BoardFreeCommentEntity) o;

        if (no != that.no) return false;
        if (boardNo != that.boardNo) return false;
        if (context != null ? !context.equals(that.context) : that.context != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = no;
        result = 31 * result + boardNo;
        result = 31 * result + (context != null ? context.hashCode() : 0);
        return result;
    }
}
