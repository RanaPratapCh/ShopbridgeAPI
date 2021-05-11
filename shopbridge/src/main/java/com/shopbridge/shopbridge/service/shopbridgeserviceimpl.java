package com.shopbridge.shopbridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopbridge.shopbridge.dao.shopbridgedao;
import com.shopbridge.shopbridge.dto.shopbridgedto;
import com.shopbridge.shopbridge.entity.shopbridge;

@Service

public class shopbridgeserviceimpl implements shopbridgeservice {
	
	@Autowired
	private shopbridgedao dao;

	@Override
	public boolean addProduct(shopbridgedto products) {
		if(dao.addProduct(products)) {
			return true;
		}
		return false;
	}

	@Override
	public List<shopbridge> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}

	@Override
	public boolean updateProduct(shopbridgedto product) {
		// TODO Auto-generated method stub
		 if(dao.updateProduct(product)) {
			 return true;
		 }
		 return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		if(dao.deleteProduct(id)) {
		return true;
	}
		return false;
	}

}
