package com.yasu.ccs.Domain.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "api_list_map", schema = "ccsyasu_db")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiListMapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "no", nullable = false)
    private Integer no;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "proper_name", nullable = false, length = 100)
    private String properName;

    @Column(name = "lat", nullable = false, scale = 6)
    private Float lat;

    @Column(name = "lng", nullable = false, scale = 6)
    private Float lng;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "place_url", nullable = false, length = 100)
    private String placeUrl;

    @Builder
    public ApiListMapEntity(Integer no, String name, String properName, Float lat, Float lng, String address, String placeUrl) {
        this.no = no;
        this.name = name;
        this.properName = properName;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.placeUrl = placeUrl;
    }
}
