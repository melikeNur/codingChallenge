package com.ayrotek.codingchallenge.repository;


import java.util.Optional;

import com.ayrotek.codingchallenge.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    
    @Query("select u from Product u where u.serialNo = ?1")
    Optional<Product> findBySerialNo(String serialNo);
}
