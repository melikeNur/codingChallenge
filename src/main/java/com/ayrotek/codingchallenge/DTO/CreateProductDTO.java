package com.ayrotek.codingchallenge.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CreateProductDTO {
    private String name;
    private String serialNo;
	private String brand;
    private String category;
    private Double amount;

    public CreateProductDTO(String name,String serialNo, String brand, String category, double amount) {
		this.name = name;
        this.serialNo = serialNo;
		this.brand = brand;
		this.category = category;
        this.amount = amount;
	}
}
