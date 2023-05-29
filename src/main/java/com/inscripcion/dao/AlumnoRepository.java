package com.inscripcion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inscripcion.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	//
	@Query("select a from Alumno a where a.apeAlumno=?1")
	public List<Alumno> listarPorApellido(String apellid);

}
