package com.ayrotek.codingchallenge.repository;

import java.util.Optional;

import com.ayrotek.codingchallenge.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client,Long> {
    
    @Query("select u from Client u where u.email = ?1")
    Optional<Client> findByEmail(String email);   
    
}
