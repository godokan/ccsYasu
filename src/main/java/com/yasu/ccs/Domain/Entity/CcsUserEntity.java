package com.yasu.ccs.Domain.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ccs_user", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor
public class CcsUserEntity {

    @Id
    @Column(name = "stud_num", unique = true, nullable = false)
    private Integer studNum;

    @Column(name = "id", nullable = false, length = 20)
    private String id;

    @Column(name = "pw", nullable = false, length = 100)
    private String pw;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Builder
    public CcsUserEntity(Integer studNum, String id, String pw, String name) {
        this.studNum = studNum;
        this.id = id;
        this.pw = pw;
        this.name = name;
    }
}
