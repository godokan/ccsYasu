package com.yasu.ccs.Domain.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board_free", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor
public class BoardFreeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private Integer no;

    @ManyToOne(cascade = CascadeType.REMOVE, targetEntity = CcsUserEntity.class)
    @JoinColumn(name = "stud_num", referencedColumnName = "stud_num", insertable = false, updatable = false)
    private CcsUserEntity studNum;

    @Column(name = "context", nullable = false, length = 2000)
    private String context;

    @Builder
    public BoardFreeEntity(Integer no, CcsUserEntity studNum, String context) {
        this.no = no;
        this.studNum = studNum;
        this.context = context;
    }
}
