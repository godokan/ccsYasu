package com.yasu.ccs.Domain.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "api_list_map", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor
public class ApiListMapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private Integer no;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "lat", nullable = false, scale = 6)
    private Float lat;

    @Column(name = "lng", nullable = false, scale = 6)
    private Float lng;

    @Builder
    public ApiListMapEntity(Integer no, String name, String description, Float lat, Float lng) {
        this.no = no;
        this.name = name;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
    }
}
