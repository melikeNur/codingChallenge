package com.ayrotek.codingchallenge.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class GeneralResponse implements ResponseInterface {
    private Boolean status;
    private int statusCode;
    private String message;
    private String detail;

    public static final String secretKey = "codingChallengeSecretKey";

    public GeneralResponse(Boolean status, int statusCode, String message, String detail){
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.detail = detail;
    }
}
