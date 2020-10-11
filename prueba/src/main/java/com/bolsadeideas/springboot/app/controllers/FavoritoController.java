package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.dto.FiltroBusquedaDTO;
import com.bolsadeideas.springboot.app.models.entity.Favorito;
import com.bolsadeideas.springboot.app.models.service.IFavoritoService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes("favorito")
public class FavoritoController {
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private IFavoritoService favoritoService;

	@RequestMapping(value = {"/listar"}, method = RequestMethod.GET)
	public String listar(@RequestParam(name="page",defaultValue="0")	
	 int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 4);
		FiltroBusquedaDTO filtro=(FiltroBusquedaDTO)request.getSession().getAttribute("filtro");
				
		Page<Favorito> favoritos = favoritoService.findByTipoAndLugarId(pageRequest, filtro.getTipo(), filtro.getLugar().getId());
		//Page<Favorito> favoritos = favoritoService.findAll(pageRequest);
		
		PageRender<Favorito> pageRender = new PageRender<Favorito>("/listar", favoritos);
		model.addAttribute("titulo", "Resultados"+" ["+filtro.getLugar().getNombre()+"-"+filtro.getTipo()+"]");
		model.addAttribute("favoritos", favoritos);
		model.addAttribute("page", pageRender);
		return "listar";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Favorito favorito = new Favorito();
		model.put("favorito", favorito);
		FiltroBusquedaDTO filtro=(FiltroBusquedaDTO)request.getSession().getAttribute("filtro");
		model.put("titulo", "Crear BookMark"+" ["+filtro.getLugar().getNombre()+"-"+filtro.getTipo()+"]");
		return "form";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Favorito favorito = null;

		if (id > 0) {
			favorito = favoritoService.findOne(id);
			if (favorito == null) {
				flash.addFlashAttribute("error", "El ID del BookMark no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del BookMark no puede ser cero!");
			return "redirect:/listar";
		}
		FiltroBusquedaDTO filtro=(FiltroBusquedaDTO)request.getSession().getAttribute("filtro");
		model.put("favorito", favorito);
		model.put("titulo", "Editar BookMark"+" ["+filtro.getLugar().getNombre()+"-"+filtro.getTipo()+"]");
		return "form";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Favorito favorito, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de BookMark");
			return "form";
		}
		String mensajeFlash = (favorito.getId() != null) ? "Bookmark editado con exito!" : "Bookmark creado con exito!";
		FiltroBusquedaDTO filtro=(FiltroBusquedaDTO)request.getSession().getAttribute("filtro");
		favorito.setLugar(filtro.getLugar());
		favorito.setTipo(filtro.getTipo());
		
		String urlInicio="https://maps.google.com/maps?width=100%25&height=60%25&hl=es&q=";
		String urlFin=",%20Spain+&t=&z=17&ie=UTF8&iwloc=B&output=embed";
		String url=urlInicio+favorito.getDireccion().replaceAll(" ", "%20")+urlFin;
		favorito.setUrl(url);		
		
		favoritoService.save(favorito);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			favoritoService.delete(id);
			flash.addFlashAttribute("success", "Bookmark eliminado con exito!");
		}
		return "redirect:/listar";
	}
	
	@RequestMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Favorito favorito = null;

		if (id > 0) {
			favorito = favoritoService.findOne(id);
			if (favorito == null) {
				flash.addFlashAttribute("error", "El ID del BookMark no existe en la BBDD!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del BookMark no puede ser cero!");
			return "redirect:/listar";
		}		
		model.addAttribute("favorito", favorito);		
		model.addAttribute("titulo", "Ver BookMark");
		return "ver";
	}
}