package com.yasu.ccs.Domain.Entity;

import com.yasu.ccs.DTO.BoardDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board_free", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(name = "date", nullable = false)
    private String date;

    @Builder
    public BoardFreeEntity(Integer no, CcsUserEntity studNum, String context, String date) {
        this.no = no;
        this.studNum = studNum;
        this.context = context;
        this.date = date;
    }

    public BoardDto toDto() {
        return BoardDto.builder()
                .no(no)
                .studNum(studNum.getStudNum())
                .context(context)
                .date(date)
                .build();
    }
}
