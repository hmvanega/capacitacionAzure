package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Product;


public interface ProductRepository extends  MongoRepository<Product, String> {
	  
	}

