package com.shopbridge.shopbridge.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopbridge.shopbridge.dto.shopbridgedto;
import com.shopbridge.shopbridge.entity.shopbridge;

@Repository

public class shopbridgedaoimpl implements shopbridgedao {

	@Autowired
	private EntityManager manager;

	@Override
	@Transactional
	public boolean addProduct(shopbridgedto products) {
		shopbridge product = new shopbridge();
		BeanUtils.copyProperties(products, product);
		manager.persist(product);		
		return true;
	}

	@Override
	public List<shopbridge> getAllProducts() {
		TypedQuery<shopbridge> product= manager.createQuery("from shopbridge", shopbridge.class);
		return product.getResultList();
	}

	@Override
	@Transactional
	public boolean updateProduct(shopbridgedto product) {
		shopbridge prod = manager.find(shopbridge.class, product.getProdId());
		BeanUtils.copyProperties(product, prod);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteProduct(int id) {
		shopbridge product = manager.find(shopbridge.class, id);
		manager.remove(product);
		return true;
	}

}
