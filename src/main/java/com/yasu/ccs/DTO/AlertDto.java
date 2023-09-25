package com.yasu.ccs.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class AlertDto {
    private String message;
    private String redirectUrl;

    @Builder
    public AlertDto(String message, String redirectUrl) {
        this.message = message;
        this.redirectUrl = redirectUrl;
    }
}
