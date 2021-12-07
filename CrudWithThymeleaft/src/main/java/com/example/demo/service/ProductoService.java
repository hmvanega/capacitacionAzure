package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;

@Service
public class ProductoService {
	
	@Autowired
    private ProductRepository productRepository;
    
    private boolean existsById(String id) {
        return productRepository.existsById(id);
    }
    
    public Product findById(String id) throws Exception {
        Product prod = productRepository.findById(id).orElse(null);
        if (prod==null) {
            throw new Exception("Cannot find Contact with id: " + id);
        }
        else return prod;
    }
    public List<Product> findAll(int pageNumber, int rowPerPage) {
        List<Product> contacts = new ArrayList<>();
        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage, 
                Sort.by("id").ascending());
        productRepository.findAll(sortedByIdAsc).forEach(contacts::add);
        return contacts;
    }
    
//    public List<Product> findAll() {
//        List<Product> products = new ArrayList<>();
//        
//        Pageable sortedByIdAsc = PageRequest.of(1 - 1, 10, 
//                Sort.by("id").ascending());
//        productRepository.findAll(sortedByIdAsc).forEach(products::add);
//        return products;
//    }
//    
    public Product save(Product product) throws Exception {
        if (!StringUtils.isEmpty(product.getNombre())) {
            if (product.getId() != null) { 
                throw new Exception("Contact with id: " + product.getId() +
                        " already exists");
            }
            return productRepository.save(product);
        }
        else {
            
            throw new Exception("Contact with id: " + product.getId() +
                    " already exists");
        }
        }
    
    
    public void update(Product product) 
            throws Exception {
        if (!StringUtils.isEmpty(product.getNombre())) {
            
            productRepository.save(product);
        }
        else {
        	throw new Exception("Cannot find Contact with id: " + product.getId());
        }
    }
    
    public void deleteById(String id) throws Exception {
        if (!existsById(id)) { 
            throw new Exception("Cannot find contact with id: " + id);
        }
        else {
        	productRepository.deleteById(id);
        }
    }
    
    public Long count() {
        return productRepository.count();
    }
}