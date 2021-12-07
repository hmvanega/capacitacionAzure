package com.bolsadeideas.springboot.webflux.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.webflux.app.models.dao.ProductoDao;
import com.bolsadeideas.springboot.webflux.app.models.documents.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoDao dao;

	@Override
	public List<Producto> findAll() {
		
		return dao.findAll();
	}

	@Override
	public Optional<Producto> findById(String id) {
		Optional<Producto> obj = dao.findById(id);
		if(obj.isPresent()) {
			return dao.findById(id);
		}
		return null;
	}

	@Override
	public void delete(Producto producto) {
		dao.delete(producto);
		
	}

	@Override
	public Producto save(Producto producto) {
		Producto produc = dao.save(producto);
		return produc;
	}
	

}
