package com.ayrotek.codingchallenge.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class LoginClientDTO {
    private String email;
    private String password;

    public LoginClientDTO(String email,String password){
        this.email = email;
        this.password = password;
    }
    
}
