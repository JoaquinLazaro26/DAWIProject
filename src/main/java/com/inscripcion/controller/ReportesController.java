package com.inscripcion.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inscripcion.entity.Alumno;
import com.inscripcion.entity.Curso;
import com.inscripcion.entity.OrdenPago;
import com.inscripcion.service.AlumnoService;
import com.inscripcion.service.CarreraService;
import com.inscripcion.service.CursoService;
import com.inscripcion.service.OrdenPagoService;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reportes")
public class ReportesController {
	@Autowired
	private AlumnoService serAlu;
	@Autowired
	private CursoService serCur;
	@Autowired
	private OrdenPagoService serOrdenPag;
	// PARA EL COMBO
	@Autowired
	private CarreraService serCar;
	
	
	// LISTAR CARRERA
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("carreras", serCar.listarCarreras());
		
		return "reportes";
	}
	
	
	
	// BUSCAR ALUMNO POR ESTADO 
	@RequestMapping("/listaAlumnoEstadoJSON")
	@ResponseBody
	public List<Alumno> listaAlumnoEstadoJSON(@RequestParam("estado") String estado) {
		return serAlu.listarPorEstado(estado);
	}
	
	// BUSCAR CURSOS POR CARRERA
	@RequestMapping("/listaCursoPorCarreraJSON")
	@ResponseBody
	public List<Curso> listaCursoPorCarreraJSON(@RequestParam("codCarrera") int cod) {
		return serCur.listarCursosPorCodigoCarrera(cod);
	}	
	// BUSCAR BOLETA POR MES Y AÑOS
	@RequestMapping("/listaBoletaJSON")
	@ResponseBody
	public List<OrdenPago> listaBoletaJSON(@RequestParam("mes") int mes) {
		return serOrdenPag.listarOrdenesPagoPorMesYaño(mes);
	}
	
	// REPORTE
	@RequestMapping("/ReporteCursoPorCarreraJSON")
	public void reporteCurso(
			@RequestParam("codCarrera") int cod,
			HttpServletResponse response) {
			try {
			//invocar al método listarTodos
			List<Curso> lista=serCur.listarCursosPorCodigoCarrera(cod);
			//acceder al reporte "reporteCliente.jrxml"
			File file=ResourceUtils.getFile("classpath:CursoReporte.jrxml");
			//crear objeto de la clase JasperReport y manipular el objeto file
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			//origen de datos "manipular lista"
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			//crear reporte
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null,origen);
			//salida del reporte en formato PDF
			response.setContentType("application/pdf");
			//
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(jasperPrint,salida);		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
	@RequestMapping("/ReporteAlumnoEstadoJSON")
	public void reporteAlumno(
			@RequestParam("estado") String estado,
			HttpServletResponse response) {
			try {
			//invocar al método listarTodos
			List<Alumno> lista=serAlu.listarPorEstado(estado);
			//acceder al reporte "reporteCliente.jrxml"
			File file=ResourceUtils.getFile("classpath:AlumnoReporte.jrxml");
			//crear objeto de la clase JasperReport y manipular el objeto file
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			//origen de datos "manipular lista"
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			//crear reporte
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null,origen);
			//salida del reporte en formato PDF
			response.setContentType("application/pdf");
			//
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(jasperPrint,salida);		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
	@RequestMapping("/ReporteBoletaJSON")
	public void reporteBoleta(
			@RequestParam("mes") int mes,
			HttpServletResponse response) {
			try {
			//invocar al método listarTodos
			List<OrdenPago> lista=serOrdenPag.listarOrdenesPagoPorMesYaño(mes);
			//acceder al reporte "reporteCliente.jrxml"
			File file=ResourceUtils.getFile("classpath:CompropagoReporte.jrxml");
			//crear objeto de la clase JasperReport y manipular el objeto file
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			//origen de datos "manipular lista"
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			//crear reporte
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null,origen);
			//salida del reporte en formato PDF
			response.setContentType("application/pdf");
			//
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(jasperPrint,salida);		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
