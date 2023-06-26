package com.inscripcion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inscripcion.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	//
	@Query("select a from Alumno a where a.apeAlumno=?1")
	public List<Alumno> listarPorApellido(String apellid);

	// JEFRY - PARA FICHA INSCRIPCION
	@Query("SELECT a FROM Alumno a WHERE a.nomAlumno LIKE CONCAT(?1, '%') AND a.estado = 'REGISTRADO'")
	List<Alumno> findByNomAlumnoStartingWithAndEstadoRegistrado(String nombre);

	// JEFRY
	@Query("select a from Alumno a where a.estado=?1")
	public List<Alumno> listarPorEstado(String estado);
	
}
