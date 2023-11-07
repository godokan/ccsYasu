package com.yasu.ccs.Domain.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "api_user_list", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiUserListEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private Integer no;

    @JoinColumn(name = "list_no", referencedColumnName = "no", insertable = false, updatable = false)
    private Integer listNo;

    @JoinColumn(name = "user_stud_num", referencedColumnName = "stud_num", insertable = false, updatable = false)
    private Integer userStudNum;

    @Builder
    public ApiUserListEntity(Integer no, Integer listNo, Integer userStudNum) {
        this.no = no;
        this.listNo = listNo;
        this.userStudNum = userStudNum;
    }
}
