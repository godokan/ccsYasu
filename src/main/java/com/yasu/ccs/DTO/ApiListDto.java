package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ApiListDto {
    int no;
    String name;
    String description;
    String id;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }
}
