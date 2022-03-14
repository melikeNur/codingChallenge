package com.ayrotek.codingchallenge.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RegisterClientDTO {
    private String name;
    private String email;
    private String password;

    public RegisterClientDTO(String name,String email,String password){
        this.name = name;
        this.email = email;
        this.password = password;
    } 
}

