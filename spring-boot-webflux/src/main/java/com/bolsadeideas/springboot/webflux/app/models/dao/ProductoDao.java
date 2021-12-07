package com.bolsadeideas.springboot.webflux.app.models.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.bolsadeideas.springboot.webflux.app.models.documents.Producto;

public interface ProductoDao extends MongoRepository<Producto, String>{

}
