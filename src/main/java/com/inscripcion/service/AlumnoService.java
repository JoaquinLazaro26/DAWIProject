package com.inscripcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inscripcion.dao.AlumnoRepository;
import com.inscripcion.entity.Alumno;

@Service
public class AlumnoService {
	@Autowired
	private AlumnoRepository repo;
	
	// J
	public List<Alumno> listarAlumnos() {
		return repo.findAll();
	}
	
	// N
	//métodos
	public void grabar(Alumno a) {
		repo.save(a);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	public Alumno buscarPorCodigo(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Alumno> listarTodos(){
		return repo.findAll();
	}
	
	//CONSULTAR POR APELLIDO
	public List<Alumno> consultaPorApellidoAlumno(String ape){
		return repo.listarPorApellido(ape);
	}
}
