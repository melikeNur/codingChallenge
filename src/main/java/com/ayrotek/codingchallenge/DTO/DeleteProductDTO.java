package com.ayrotek.codingchallenge.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DeleteProductDTO {
    private String serialNo;

    public DeleteProductDTO(String serialNo){
        this.serialNo = serialNo;
    }
}
