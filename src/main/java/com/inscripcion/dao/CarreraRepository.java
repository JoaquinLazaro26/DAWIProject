package com.inscripcion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inscripcion.entity.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera, Integer>{
	
	// JEFRYYY - FICHA INSCRIPCION
	@Query("select e from Carrera e where e.codigo=?1")
	public List<Carrera> listarCarrerasPorCodigo(int codigo);

}
