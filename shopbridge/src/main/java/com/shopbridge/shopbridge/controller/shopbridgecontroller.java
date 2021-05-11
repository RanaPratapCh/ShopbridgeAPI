package com.shopbridge.shopbridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopbridge.shopbridge.dto.responce;
import com.shopbridge.shopbridge.dto.shopbridgedto;
import com.shopbridge.shopbridge.entity.shopbridge;
import com.shopbridge.shopbridge.service.shopbridgeservice;

@RestController
public class shopbridgecontroller{
	@Autowired
	private shopbridgeservice service;
	
	@PostMapping("/api/add-product")
	public responce addProduct(@RequestBody shopbridgedto product)
	{
		responce res = new responce();
		
		if(service.addProduct(product))
		{
			res.setStatusCode(200);
			res.setMessage("Product Added Successfully.");
			res.setDescription("Product Item Added Successfully to the Database.");
		}
		else {
			res.setStatusCode(401);
			res.setMessage("Product Not Added.");
			res.setDescription("Unsuccessfull Insertion by you.");
		}
		
		return res;	
	}
	
	@GetMapping("/api/all-Products")
	public responce  getAllProducts(){
		
		responce res = new responce();
		
		List<shopbridge> product=service.getAllProducts();
		
		if(product.size() != 0) {
			res.setStatusCode(200);
			res.setMessage("product details fetched successfully");
			res.setDescription("Getting Success");
			res.setProducts(product);
		}
		else {
			res.setStatusCode(401);
			res.setMessage("product details reteived failed");
			res.setDescription("Getting failed");
		}
		return res;
	}
	
	@DeleteMapping("/api/delete-product/{productId}")
	public responce deleteProduct(@PathVariable("productId") int id) {
		
		responce res = new responce();
		if(service.deleteProduct(id)) {
			res.setStatusCode(200);
			res.setMessage("product deleted successfully");
			res.setDescription("Deleted Success");
		}
		else {
			res.setStatusCode(401);
			res.setMessage("product not deleted.");
			res.setDescription("Deletion Failed.");
		}
		return res;
	}
	
	@PutMapping("/api/update-product")
	public responce updateProduct(@RequestBody shopbridgedto product){
		
		responce res = new responce();
		if(service.updateProduct(product)) {
			res.setStatusCode(200);
			res.setMessage("product updated successfully");
			res.setDescription("updated Success");
		}
		else {
			res.setStatusCode(401);
			res.setMessage("product not updated.");
			res.setDescription("updation Failed.");
		}
		return res;
		
	}
}
