package com.bolsadeideas.springboot.webflux.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.webflux.app.models.documents.Producto;
import com.bolsadeideas.springboot.webflux.app.models.service.ProductoService;



@Controller
@RequestMapping("/view/clientes")
public class ProductoController {

	@Autowired(required=true)
	private ProductoService service;
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		List<Producto> productos = service.findAll();
				
		model.addAttribute("productos", productos);
		model.addAttribute("titulo", "Listado de productos");
		return "listar";
	}
	
	@GetMapping("/")
	public String inicio() {
		
		return "home";
	}
	@GetMapping("/guardar")
	public String save(Model model) {
		System.out.println("entro al metodo guardar");
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		
		return "guardarProducto";
	}
	
	@PostMapping("/save")
	public String guardarProducto(@ModelAttribute Producto producto) {        
	    try {
	    	service.save(producto);
	    	System.out.println("se agrego el producto satisfactoriamente");
	        return "redirect:/view/clientes/listar" ;
	    } catch (Exception ex) {
	        // log exception first, 
	        // then show error
	        String errorMessage = ex.getMessage();
	       
	        //model.addAttribute("contact", contact);
	       
	        return "guardarProducto";
	    }        
	}

}
