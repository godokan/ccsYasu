package com.yasu.ccs.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ccs_user", schema = "ccsyasu_db")
public class CcsUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "stud_num", nullable = false)
    private int studNum;
    @Basic
    @Column(name = "id", nullable = false, length = 20)
    private String id;
    @Basic
    @Column(name = "pw", nullable = false, length = 100)
    private String pw;
    @Basic
    @Column(name = "name", nullable = false, length = 40)
    private String name;

    public int getStudNum() {
        return studNum;
    }

    public void setStudNum(int studNum) {
        this.studNum = studNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CcsUserEntity that = (CcsUserEntity) o;

        if (studNum != that.studNum) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (pw != null ? !pw.equals(that.pw) : that.pw != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studNum;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (pw != null ? pw.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
