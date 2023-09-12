package com.yasu.ccs.Domain.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "api_user", schema = "ccsyasu_db", catalog = "")
public class ApiUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private int no;
    @Basic
    @Column(name = "api_key", nullable = false, length = 100)
    private String apiKey;
    @Basic
    @Column(name = "stud_num", nullable = false)
    private int studNum;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public int getStudNum() {
        return studNum;
    }

    public void setStudNum(int studNum) {
        this.studNum = studNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiUserEntity that = (ApiUserEntity) o;

        if (no != that.no) return false;
        if (studNum != that.studNum) return false;
        if (apiKey != null ? !apiKey.equals(that.apiKey) : that.apiKey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = no;
        result = 31 * result + (apiKey != null ? apiKey.hashCode() : 0);
        result = 31 * result + studNum;
        return result;
    }
}
