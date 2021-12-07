package com.bolsadeideas.springboot.webflux.app.models.service;

import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.webflux.app.models.documents.Producto;

public interface ProductoService  {

	public List<Producto> findAll();
	
	public Optional<Producto> findById(String id);
	
	public void delete(Producto producto);
	
	public Producto save(Producto producto);
	
	
	
}
