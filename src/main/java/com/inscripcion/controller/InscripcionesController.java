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
import com.inscripcion.service.AlumnoService;
import com.inscripcion.service.CarreraService;
import com.inscripcion.service.InscripcionesService;

@Controller
@RequestMapping("/inscripcion")
public class InscripcionesController {
	@Autowired
	private InscripcionesService serIns;
	@Autowired
	private CarreraService serCar;
	@Autowired
	private AlumnoService serAlu;
	
	
	// LISTAR TABLA
	@RequestMapping("/lista")
	private String index(Model model) {
		model.addAttribute("inscripciones", serIns.listarInscripciones());
		model.addAttribute("carreras", serCar.listarCarreras());
		model.addAttribute("alumnos", serAlu.listarAlumnos());
		
		return "inscripcion";
	}
	
	// ACTUAIZAR
	@RequestMapping("/grabar")
	private String grabar(
			@RequestParam("codigo") String cod,
			@RequestParam("tipoCarrera") int codCar,
			@RequestParam("dniSAlumno") int codAlu,
			@RequestParam("fechaIns") String fec,
			@RequestParam("estado") String estado,
			RedirectAttributes redirect){
		try {
			//
			Inscripcion i = new Inscripcion();
			i.setCodigo(cod);
			//
			Carrera c = new Carrera();
			c.setCodigo(codCar);
			i.setTipoCarrera(c);
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

	//
	@RequestMapping("/buscar")
	@ResponseBody
	private Inscripcion buscarPorCodigo(
			@RequestParam("codigo") String cod) {
			return serIns.buscarPorID(cod);
	}
		
}
