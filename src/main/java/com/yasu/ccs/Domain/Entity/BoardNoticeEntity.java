package com.yasu.ccs.Domain.Entity;

import com.yasu.ccs.DTO.BoardDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board_notice", schema = "ccsyasu_db")
public class BoardNoticeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", unique = true, nullable = false)
    private Integer no;

    @ManyToOne(cascade = CascadeType.REMOVE, targetEntity = CcsUserEntity.class)
    @JoinColumn(name = "stud_num", referencedColumnName = "stud_num", insertable = false, updatable = false)
    private CcsUserEntity studNum;

    @Column(name = "context", nullable = false, length = 2000)
    private String context;

    @Column(name = "date", nullable = false)
    private String date;

    @Builder
    public BoardNoticeEntity(Integer no, CcsUserEntity studNum, String context, String date) {
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
