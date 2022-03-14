package com.ayrotek.codingchallenge.services;

import java.util.List;

import com.ayrotek.codingchallenge.DTO.CreateProductDTO;
import com.ayrotek.codingchallenge.DTO.DeleteProductDTO;
import com.ayrotek.codingchallenge.DTO.UpdateProductDTO;
import com.ayrotek.codingchallenge.model.Client;
import com.ayrotek.codingchallenge.response.GeneralResponse;

import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<GeneralResponse> createProduct(CreateProductDTO body,Client client);

    ResponseEntity<GeneralResponse> updateProduct(UpdateProductDTO body, Client client);

    ResponseEntity<GeneralResponse> deleteProduct(DeleteProductDTO body, Client client);

    ResponseEntity<List> getAllProducts();
}
