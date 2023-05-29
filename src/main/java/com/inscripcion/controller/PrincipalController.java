package com.inscripcion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paginaPrincipal")
public class PrincipalController {
	
	// LISTAR TABLA
		@RequestMapping("/home")
		private String index(Model model) {
			
			return "paginaPrincipal";
		}

}
