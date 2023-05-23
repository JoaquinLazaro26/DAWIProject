package com.inscripcion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inscripcion.entity.Inscripcion;

public interface InscripcionesRepository extends JpaRepository<Inscripcion, String>{
	
}
