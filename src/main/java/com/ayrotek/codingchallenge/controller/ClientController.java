package com.ayrotek.codingchallenge.controller;

import com.ayrotek.codingchallenge.DTO.LoginClientDTO;
import com.ayrotek.codingchallenge.DTO.RegisterClientDTO;
import com.ayrotek.codingchallenge.response.GeneralResponse;
import com.ayrotek.codingchallenge.services.ClientService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api")
public class ClientController {
    
    private final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/registerClient")
    public ResponseEntity<GeneralResponse> createClient(@RequestBody RegisterClientDTO body){
        try {
           return clientService.registerClient(body);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }     
    }
    @PostMapping("/loginClient")
    public ResponseEntity<GeneralResponse> loginClient(@RequestBody LoginClientDTO body){
        try {
            return clientService.loginClient(body);
            
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }     
    }

    
}
