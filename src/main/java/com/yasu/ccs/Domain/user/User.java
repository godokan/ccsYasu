package com.yasu.ccs.Domain.user;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
public class User {

    @Id
    @Column(unique = true, length = 9, nullable = false)
    private int stud_num;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 100, nullable = false)
    private String pw;

    @Column(length = 40, nullable = false)
    private String name;

//    stud_num	int		not null	primary key,
//    id			varchar(20)		not null,
//    pw			varchar(100)	not null,
//    name		varchar(40)		not null
//            )	engine=InnoDB charset = utf8mb4;
}
