package com.yasu.ccs.Domain.Entity;

import com.yasu.ccs.DTO.BoardDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "board_free", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardFreeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private Integer no;

    @JoinColumn(name = "stud_num", referencedColumnName = "stud_num", insertable = false, updatable = false)
    private Integer studNum;

    @Column(name = "context", nullable = false, length = 2000)
    private String context;

    @Column(name = "date")
    private String date;

    @Builder
    public BoardFreeEntity(Integer no, Integer studNum, String context, String date) {
        this.no = no;
        this.studNum = studNum;
        this.context = context;
        this.date = date;
    }

    public BoardDto toDto() {
        return BoardDto.builder()
                .no(no)
                .studNum(studNum)
                .context(context)
                .date(date)
                .build();
    }
}
