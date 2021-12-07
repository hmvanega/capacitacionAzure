package com.example.demo.controller;

import java.util.List;

import org.hibernate.mapping.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Product;
import com.example.demo.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoController {

	private static final long serialVersionUID = 4048798961366546485L;
	
	public static final String VISTA_LISTA = "lista";
	public static final String VISTA_CREAR = "producto";
	//public static final String VISTA_FORMULARIO = "producto";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
    private final int ROW_PER_PAGE = 5;
	
	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;

	@Autowired
	private ProductoService productoService;

	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
	    model.addAttribute("nombre", nombreAplicacion);
	    return "index";
	}
	@GetMapping(value = {"/", "/index2"})
	public String index2(Model model) {
	    model.addAttribute("nombre", nombreAplicacion);
	    return "index2";
	}
	
//	@GetMapping(value = "/lista")
//	public String listar(Model model) {
//		model.addAttribute("titulo", nombreAplicacion);
//		model.addAttribute("productos", productoService.findAll());
//
//		return VISTA_LISTA;
//	}
	@GetMapping(value = "/lista")
	public String getContacts(Model model,
	        @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
	    List<Product> contacts = productoService.findAll(pageNumber, ROW_PER_PAGE);
	 
	    long count = productoService.count();
	    boolean hasPrev = pageNumber > 1;
	    boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;
	    model.addAttribute("contacts", contacts);
	    model.addAttribute("hasPrev", hasPrev);
	    model.addAttribute("prev", pageNumber - 1);
	    model.addAttribute("hasNext", hasNext);
	    model.addAttribute("next", pageNumber + 1);
	    return "lista-productos";
	}

//	@GetMapping(value = "/listaModelMap")
//	public String listarModelMap(ModelMap model) {
//		model.addAttribute("titulo", nombreAplicacion);
//		model.addAttribute("productos", productoService..obtenerTodosProductos());
//
//		return VISTA_LISTA;
//	}

//	@GetMapping("/listaModelAndView")
//	public ModelAndView listarModelAndView() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("titulo", nombreAplicacion);
//		mav.addObject("productos", productoService.obtenerTodosProductos());
//		mav.setViewName(VISTA_LISTA);
//
//		return mav;
//	}

//	@GetMapping("/crear")
//	public String crear(Map model) {
//		Product producto = new Product();
//		model.put("producto", producto);
//		model.put("titulo", nombreAplicacion);
//
//		return VISTA_FORMULARIO;
//	}
//
//	@PostMapping("/guardar")
//	public String guardar(Product producto) throws Exception{
//		productoService.save(producto);
//
//		return "redirect:" + VISTA_LISTA;
//	}
	@GetMapping("/formulario")
	public String formulario() throws Exception{
		
		return "redirect:" + VISTA_CREAR;
	}
//
//	@GetMapping("/eliminar/{id}")
//	public String eliminar(@PathVariable(value="id") Integer idProducto) {
//		productoService.eliminar(idProducto);
//
//		return "redirect:../" + VISTA_LISTA;
//	}

}



