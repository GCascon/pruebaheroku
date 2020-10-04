package com.bolsadeideas.springboot.app.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolsadeideas.springboot.app.models.dto.FiltroBusquedaDTO;
import com.bolsadeideas.springboot.app.models.entity.Lugar;
import com.bolsadeideas.springboot.app.models.service.ILugarService;


@Controller
@SessionAttributes("filtro")
public class IndexController {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	ILugarService lugarService;

	@GetMapping(value= {"","buscar"})
	public String mostrar(Model model) {
		FiltroBusquedaDTO filtro=new FiltroBusquedaDTO();
		model.addAttribute("filtro", filtro);
		model.addAttribute("titulo", "Qu&eacute; hay en ...");
		request.getSession().setAttribute("filtro", filtro);
		return "buscar";
	}
	
	@PostMapping("/buscar")
	public String procesar(@Valid FiltroBusquedaDTO filtro, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Que hay en ...");
			model.addAttribute("filtro", filtro);
			return "buscar";
		}
		model.addAttribute("filtro", filtro);
		request.getSession().setAttribute("filtro", filtro);
		return "redirect:/listar/";
	}
	
	@ModelAttribute("listaLugares")
	public List<Lugar> listaLugares() {
		return lugarService.findAll();
	}
	
	@ModelAttribute("tipos")
	public List<String> tipos(){
		return Arrays.asList("Turismo", "Tapeo", "Restaurantes");
	}
}
