package com.ayrotek.codingchallenge.services;

import com.ayrotek.codingchallenge.DTO.LoginClientDTO;
import com.ayrotek.codingchallenge.DTO.RegisterClientDTO;
import com.ayrotek.codingchallenge.response.GeneralResponse;

import org.springframework.http.ResponseEntity;

public interface ClientService {
    ResponseEntity<GeneralResponse> registerClient(RegisterClientDTO body);
    ResponseEntity<GeneralResponse> loginClient(LoginClientDTO body);
}
