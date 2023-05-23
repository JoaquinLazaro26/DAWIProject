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
import com.inscripcion.entity.Pais;
import com.inscripcion.service.AlumnoService;
import com.inscripcion.service.PaisServices;


@Controller
@RequestMapping("/alumno")//CONECTA CON HTML
public class AlumnoController {
	@Autowired
	private AlumnoService serAlumno;
	
	@Autowired
	private PaisServices serPais;
	
	//LISTAR ALUMNOS
		@RequestMapping("/lista")
		public String index(Model model) {
			model.addAttribute("listaAlumnos", serAlumno.listarTodos());
			model.addAttribute("listaPaises", serPais.listarTodos());
			return "alumno";
		}

	@RequestMapping("/registrar")
		public String grabar( @RequestParam("codigo")Integer cod,
							  @RequestParam("nomAlumno")String nombre,
							  @RequestParam("apeAlumno")String apellido,
							  @RequestParam("fecNacimiento")String fecha,
							  @RequestParam("correoAlu")String correo,
							  @RequestParam("pais")Integer codPais,
							  RedirectAttributes redirect){
			
				try {
					Alumno a=new Alumno();
					a.setNomAlumno(nombre);
					a.setApeAlumno(apellido);
					a.setFecNacimiento(LocalDate.parse(fecha));
					a.setCorreoAlu(correo);
					
					Pais p=new Pais();
					p.setCodPais(codPais);
					
					//llave
					a.setPais(p);
					
					if(cod==0) {
						serAlumno.grabar(a);
						redirect.addFlashAttribute("MENSAJE","Alumno registrado");
					}//ACTUALIZAR ALUMNO
					else {
						a.setCodigo(cod);
						serAlumno.grabar(a);
						redirect.addFlashAttribute("MENSAJE", "Alumno actualizado");
					}
					
				} catch (Exception e) {
					redirect.addFlashAttribute("MENSAJE","Error en el registro");
					e.printStackTrace();
				}
				return "redirect:/alumno/lista";
		}
		
		//ELIMINAR ALUMNO
		@RequestMapping("/eliminar")
		public String eliminarPorCodigo (@RequestParam("codigo")Integer cod,
											RedirectAttributes redirect) {
			serAlumno.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE","Alumno eliminado");
			return "redirect:/alumno/lista";
		}
	
		//CONSULTAR ALUMNO
		@RequestMapping("/buscar")
		@ResponseBody
		public Alumno buscarPorCodigo(@RequestParam("codigo")Integer cod,
										RedirectAttributes redirect) {
			return serAlumno.buscarPorCodigo(cod);
		}
	

	
	
	
	

}
