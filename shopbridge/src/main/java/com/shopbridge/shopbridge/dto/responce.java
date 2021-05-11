package com.shopbridge.shopbridge.dto;

import java.util.List;

import com.shopbridge.shopbridge.entity.shopbridge;


public class responce {
	
	private int statusCode;
	
	private String message;
	
	private String description;
	
	private List<shopbridge> products;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<shopbridge> getProducts() {
		return products;
	}

	public void setProducts(List<shopbridge> products) {
		this.products = products;
	}
	
}
