package com.shopbridge.shopbridge.service;

import java.util.List;

import com.shopbridge.shopbridge.dto.shopbridgedto;
import com.shopbridge.shopbridge.entity.shopbridge;

public interface shopbridgeservice {
	public boolean addProduct(shopbridgedto products);
	
	public List<shopbridge> getAllProducts();
	
	public boolean updateProduct(shopbridgedto product);
	
	public boolean deleteProduct(int id);
}
