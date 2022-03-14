package com.ayrotek.codingchallenge.services;

import java.util.Optional;

import com.ayrotek.codingchallenge.DTO.LoginClientDTO;
import com.ayrotek.codingchallenge.DTO.RegisterClientDTO;
import com.ayrotek.codingchallenge.auth.GenerateToken;
import com.ayrotek.codingchallenge.model.Client;
import com.ayrotek.codingchallenge.repository.ClientRepository;
import com.ayrotek.codingchallenge.response.GeneralResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public ResponseEntity<GeneralResponse> registerClient(RegisterClientDTO body) { 
        Optional<Client> client = clientRepository.findByEmail(body.getEmail());
        if(client.isPresent()){
            GeneralResponse response = new GeneralResponse(false, 200,"This e-mail address is already registered. Sign in.",null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        Client newClient = new Client(body.getName(), body.getEmail(), body.getPassword());
        clientRepository.save(newClient);
        GeneralResponse response = new GeneralResponse(true, 200,"successfully registered",null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GeneralResponse> loginClient(LoginClientDTO body) {
        String token = GenerateToken.generateToken(body.getEmail());
        Optional<Client> client = clientRepository.findByEmail(body.getEmail());

        if(client.isPresent()){
            if(client.get().getPassword().equals(body.getPassword())){
                GeneralResponse response = new GeneralResponse(true, 200,"success",token);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else{
                GeneralResponse response = new GeneralResponse(false, 401,"password missmatch",null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }  
        }else{
            GeneralResponse response = new GeneralResponse(false, 404,"email not found",null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    
}
