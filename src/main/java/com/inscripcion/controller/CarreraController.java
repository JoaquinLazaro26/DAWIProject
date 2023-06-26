package com.inscripcion.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inscripcion.entity.Carrera;
import com.inscripcion.service.CarreraService;
import com.inscripcion.service.FacultadService;


import com.inscripcion.entity.Facultad;

@Controller
@RequestMapping("/Carrera")
public class CarreraController {
	
	@Autowired
	private CarreraService serCarrera;
	
	@Autowired
	private FacultadService serFacultad;
	
	
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		model.addAttribute("carreras",serCarrera.ListarCarreras());
		model.addAttribute("facus", serFacultad.ListarFacultades());
		
		return "carrera";
	}

	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") Integer cod, RedirectAttributes redirect) {
		
		try {
			serCarrera.eliminarPorID(cod);
			redirect.addFlashAttribute("exito", "la carrera ha sido eliminada");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("Error", "Error Error Error");
		}
			
		return "redirect:/Carrera/lista";
	}
	
	@RequestMapping("/grabar")
	public String grabar( @RequestParam("codigo") int cod, 
						 @RequestParam("nombre") String nom, 
						 @RequestParam("ciclo") String ciclo,
						 @RequestParam("creditos") int creditos, 
						 @RequestParam("Facultad") int Facultad,
						 @RequestParam("costo") int costo,
						 RedirectAttributes redirect) {

		try {
		
			Carrera med = new Carrera();
			med.setNomCarrera(nom);
			med.setCiclos(ciclo);
			med.setCreditos(creditos);
			Facultad tp = new Facultad();
			tp.setCodigo(Facultad);
			med.setFacultad(tp);
			//
			med.setCosto(costo);

			if(cod==0) {
				serCarrera.registrar(med);
				redirect.addFlashAttribute("MENSAJE","Carrera Registrada");
			}//ACTUALIZAR ALUMNO
			else {
				med.setCodigo(cod);
				serCarrera.actualizar(med);
				redirect.addFlashAttribute("MENSAJE", "Carrera actualizado");
			}
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el registro");
			e.printStackTrace();
		}
		return "redirect:/Carrera/lista";
}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Carrera actualizar(@RequestParam("codigo") Integer cod) {

		return serCarrera.buscarPorID(cod);
	}
	
	
	
	 
}
