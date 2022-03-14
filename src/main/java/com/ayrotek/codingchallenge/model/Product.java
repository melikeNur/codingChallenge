package com.ayrotek.codingchallenge.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter @Setter @NoArgsConstructor
public class Product {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(unique=true)
    private String serialNo;

	private String name;
	private String brand;
    private String category;
    private Double amount;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Client client;

    public Product(String name,String serialNo, String brand, String category, double amount ) {
		this.name = name;
        this.serialNo = serialNo;
		this.brand = brand;
		this.category = category;
        this.amount = amount;
	}

}
