package com.inscripcion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.inscripcion.entity.Alumno;

import jakarta.transaction.Transactional;
@Transactional
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	@Query("select a from Alumno a where a.apeAlumno=?1")
	public List<Alumno> listarPorApellido(String apellid);

	// JEFRY - PARA FICHA INSCRIPCION
	@Query("SELECT a FROM Alumno a WHERE a.nomAlumno LIKE CONCAT(?1, '%') AND a.estado = 'REGISTRADO'")
	List<Alumno> findByNomAlumnoStartingWithAndEstadoRegistrado(String nombre);

	// JEFRY
	@Query("select a from Alumno a where a.estado=?1")
	public List<Alumno> listarPorEstado(String estado);
	
	@Modifying
	@Query("update Alumno a set a.estado='INSCRITO' where a.codigo=?1")
	public void updateEstado(int codigo);
}
