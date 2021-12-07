package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Product implements Serializable {

	@Id
    private String id;
	
	private Long codigo;
	private String nombre;
	private Double precio;
	
	public Product() {
		
	}
	public Product(String id, Long codigo, String nombre, Double precio) {
		
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	

	
}
