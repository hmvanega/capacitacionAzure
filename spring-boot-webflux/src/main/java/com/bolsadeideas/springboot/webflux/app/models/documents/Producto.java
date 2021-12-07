package com.bolsadeideas.springboot.webflux.app.models.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="productos")
public class Producto {
	
	@Id
	private String id;
	
	private String nombre;
	
	private String precio;
	
	private String createAt;

	public Producto() {}

	public Producto(String nombre, String precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	
	

}
