package com.inscripcion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inscripcion.entity.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{
	
	@Query("select c from Ciudad c where c.pais.codPais=?1")
	public List<Ciudad> listarPorPais(Integer codigoPais);

}
