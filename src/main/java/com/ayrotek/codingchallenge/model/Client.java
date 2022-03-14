package com.ayrotek.codingchallenge.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="client")
@Getter @Setter @NoArgsConstructor
public class Client {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String email;
	private String password;

	@JsonManagedReference
	@OneToMany(mappedBy = "client")
    private Set<Product> product;
 
    public Client(String name,String email,String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}  
}
