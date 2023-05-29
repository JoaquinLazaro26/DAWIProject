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
		model.addAttribute("inscripciones", serIns.buscarInscripcionesPorEstado("PENDIENTE DE PAGO"));
		model.addAttribute("ordenes", serOrden.listarOrdenPago());
		model.addAttribute("generarCod", serOrden.GenerarCodigo());
		
		return "ordenpago";
	}
	@RequestMapping("/buscar")
	@ResponseBody
	private OrdenPago buscarPorCodigo( @RequestParam("codigo") String cod) {
			return serOrden.buscarPorCodigo(cod);
	}
	
	@RequestMapping("/pagar")
	private String grabar(
			@RequestParam("codigo") String cod,
			@RequestParam("monto") double monto,
			@RequestParam("inscripcion") String inscripcion,
			RedirectAttributes redirect){
		try {
			//
			OrdenPago o = new OrdenPago();
			o.setCodigo(cod);
			o.setFecha(LocalDate.now());
			o.setMonto(monto);
			o.setEstado("PAGADO");
			
			Inscripcion i = new Inscripcion();
			i.setCodigo(inscripcion);
			serIns.buscarPorID(inscripcion).setEstado("PAGADO");
			o.setInscripciones(i);
			
			if(cod=="") {
				serOrden.grabar(o);
				redirect.addFlashAttribute("MENSAJE","Boleta pagada");
			} else {
				o.setCodigo(cod);
				serOrden.actualizar(o);
				redirect.addFlashAttribute("MENSAJE","Boleta actualizada");
			}
			
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el registro");
			e.printStackTrace();
		}
		
		return "redirect:/ordenpago/lista";
	}

	@RequestMapping("/eliminar")
	public String eliminarPorCodigo (@RequestParam("codigo")String cod,
										RedirectAttributes redirect) {
		serOrden.eliminar(cod);
		redirect.addFlashAttribute("MENSAJE","Alumno eliminado");
		return "redirect:/ordenpago/lista";
	}


}
