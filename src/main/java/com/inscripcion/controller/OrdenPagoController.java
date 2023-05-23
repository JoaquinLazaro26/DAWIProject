package com.inscripcion.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inscripcion.entity.Alumno;
import com.inscripcion.entity.Carrera;
import com.inscripcion.entity.Inscripcion;
import com.inscripcion.entity.OrdenPago;
import com.inscripcion.service.InscripcionesService;
import com.inscripcion.service.OrdenPagoService;

@Controller
@RequestMapping("/ordenpago")
public class OrdenPagoController {
	@Autowired
	private OrdenPagoService serOrden;
	@Autowired
	private InscripcionesService serIns;
	
	@RequestMapping("/lista")
	private String index(Model model) {
		model.addAttribute("inscripciones", serIns.listarInscripciones());
		model.addAttribute("ordenes", serOrden.listarOrdenPago());
		
		return "ordenpago";
	}
	@RequestMapping("/buscar")
	@ResponseBody
	private OrdenPago buscarPorCodigo( @RequestParam("codigo") String cod) {
			return serOrden.buscarPorCodigo(cod);
	}
	
	
	
	
	/*
	@RequestMapping("/grabar")
	private String grabar(
			@RequestParam("codigo") Integer cod,
			@RequestParam("monto") double monto,
			@RequestParam("fecha") String fec,
			@RequestParam("estado") int codestado,
			RedirectAttributes redirect){
		try {
			//
			OrdenPago i = new OrdenPago();
			i.setCodigo(cod);
			i.setFecha(LocalDate.now());
			i.setMonto(monto);
			
			
			//
			Alumno a = new Alumno();
			a.setCodigo(codAlu);
			i.setDniSAlumno(a);
			//
			i.setFechaIns(LocalDate.parse(fec));
			i.setEstado(estado);
			if(cod=="") {
				serIns.registrar(i);
				//
				redirect.addFlashAttribute("MENSAJE","Inscripcion registrada");
			} else {
				i.setCodigo(cod);
				serIns.actualizar(i);
				//
				redirect.addFlashAttribute("MENSAJE","Inscripcion actualizada");
			}
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el registro");
			e.printStackTrace();
		}
		
		return "redirect:/inscripcion/lista";
	}

*/


}
