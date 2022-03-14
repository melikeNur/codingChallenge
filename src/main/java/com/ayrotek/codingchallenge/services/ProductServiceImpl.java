package com.ayrotek.codingchallenge.services;

import java.util.List;
import java.util.Optional;

import com.ayrotek.codingchallenge.DTO.CreateProductDTO;
import com.ayrotek.codingchallenge.DTO.DeleteProductDTO;
import com.ayrotek.codingchallenge.DTO.UpdateProductDTO;
import com.ayrotek.codingchallenge.model.Client;
import com.ayrotek.codingchallenge.model.Product;
import com.ayrotek.codingchallenge.repository.ProductRepository;
import com.ayrotek.codingchallenge.response.GeneralResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<GeneralResponse> createProduct(CreateProductDTO body,Client client) {
        Product product = new Product(body.getName(),body.getSerialNo(), body.getBrand(), body.getCategory(),body.getAmount());
        product.setClient(client);
        productRepository.save(product);
        GeneralResponse response = new GeneralResponse(true, 200,"The product has been successfully added",null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GeneralResponse> updateProduct(UpdateProductDTO body, Client client) {
        Optional<Product> product = productRepository.findBySerialNo(body.getSerialNo());
        if(product.isPresent() && (product.get().getClient().getId() == client.getId())){
            product.get().setName(body.getName());
            product.get().setBrand(body.getBrand());
            product.get().setCategory(body.getCategory());
            product.get().setAmount(body.getAmount());
            productRepository.save(product.get());
            
            GeneralResponse response = new GeneralResponse(true, 200,"The product has been successfully updated",null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{ 
            GeneralResponse response = new GeneralResponse(false, 403,"The customer can only make changes to their products, try using a different serial number",null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

}

    @Override
    public ResponseEntity<GeneralResponse> deleteProduct(DeleteProductDTO body, Client client) {
        Optional<Product> product = productRepository.findBySerialNo(body.getSerialNo());
        if(product.isPresent() && (product.get().getClient().getId() == client.getId())){
            productRepository.delete(product.get());

            GeneralResponse response = new GeneralResponse(true, 200,"The product has been successfully deleted",null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{ 
            GeneralResponse response = new GeneralResponse(false, 403,"The customer can only make changes to their products, try using a different serial number",null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }
    @Override
    public ResponseEntity<List> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    } 
}
