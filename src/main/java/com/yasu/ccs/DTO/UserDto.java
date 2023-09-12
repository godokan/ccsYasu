package com.yasu.ccs.DTO;

import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;


@Data
public class UserDto {
    @NonNull
    private Integer stud_num;
    private String id;
    private String pw;
    private String name;
}
