package com.bolsadeideas.springboot.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(Exception.class)
	public String aritmeticaError(Exception ex, Model model) {
		model.addAttribute("error", "Ups! Se ha producido un error en la aplicación :-(");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		ex.printStackTrace();
	
		return "error/generica";
	}
	
}
