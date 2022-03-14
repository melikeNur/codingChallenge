package com.ayrotek.codingchallenge.controller;

import java.util.List;
import java.util.Optional;

import com.ayrotek.codingchallenge.DTO.CreateProductDTO;
import com.ayrotek.codingchallenge.DTO.DeleteProductDTO;
import com.ayrotek.codingchallenge.DTO.UpdateProductDTO;
import com.ayrotek.codingchallenge.auth.TokenCheck;
import com.ayrotek.codingchallenge.model.Client;
import com.ayrotek.codingchallenge.repository.ClientRepository;
import com.ayrotek.codingchallenge.response.GeneralResponse;
import com.ayrotek.codingchallenge.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class ProductController {
    
    @Autowired
    ClientRepository clientRepository;

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/createProduct")
    public ResponseEntity<GeneralResponse> createProduct(@RequestHeader("Authorization") String header, @RequestBody CreateProductDTO body) {
        if(TokenCheck.checkToken(header) != null){
            String email = TokenCheck.checkToken(header);
            Optional<Client> client = clientRepository.findByEmail(email);
            if(client.isPresent()){
                return productService.createProduct(body,client.get());
            }else{
                GeneralResponse response = new GeneralResponse(false, 403,
                "UNAUTHORIZED", "Invalid email address");
                return ResponseEntity.ok(response);
            } 
        }else{
            GeneralResponse response = new GeneralResponse(false, 403,
            "UNAUTHORIZED", "token is invalid");
            return ResponseEntity.ok(response);
        }
        
    }
   @PutMapping("/updateProduct")
   public ResponseEntity<GeneralResponse> updateProduct(@RequestHeader("Authorization") String header, @RequestBody UpdateProductDTO body) {
    if(TokenCheck.checkToken(header) != null){
        String email = TokenCheck.checkToken(header);
        Optional<Client> client = clientRepository.findByEmail(email);
        if(client.isPresent()){
            return productService.updateProduct(body,client.get());
        }else{
            GeneralResponse response = new GeneralResponse(false, 403,
            "UNAUTHORIZED", "Invalid email address");
            return ResponseEntity.ok(response);
        } 
    }else{
        GeneralResponse response = new GeneralResponse(false, 403,
        "UNAUTHORIZED", "token is invalid");
        return ResponseEntity.ok(response);
        }

   }
   @DeleteMapping("/deleteProduct")
   public ResponseEntity<GeneralResponse> deleteProduct(@RequestHeader("Authorization") String header, @RequestBody DeleteProductDTO body) {
    if(TokenCheck.checkToken(header) != null){
        String email = TokenCheck.checkToken(header);
        Optional<Client> client = clientRepository.findByEmail(email);
        if(client.isPresent()){
            return productService.deleteProduct(body,client.get());
        }else{
            GeneralResponse response = new GeneralResponse(false, 403,
            "UNAUTHORIZED", "Invalid email address");
            return ResponseEntity.ok(response);
        } 
    }else{
        GeneralResponse response = new GeneralResponse(false, 403,
        "UNAUTHORIZED", "token is invalid");
        return ResponseEntity.ok(response);
        }

   }
   @GetMapping("/getAllProducts")
   public ResponseEntity<List> getAllProducts(@RequestHeader("Authorization") String header) {
        return productService.getAllProducts();
   }
}
