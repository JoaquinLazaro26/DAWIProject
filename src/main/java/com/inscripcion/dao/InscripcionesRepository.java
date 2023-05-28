package com.inscripcion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inscripcion.entity.Inscripcion;

public interface InscripcionesRepository extends JpaRepository<Inscripcion, String>{
	@Query("select i from Inscripcion i where i.estado=?1")
	public Inscripcion buscarInscripcionEstado(String estado);
	
	// QUERY PARA EJECUTAR EL PROCEDURE DE GENERAR CODIGO DE INSCRIPCION
	@Query(value="{call sp_generar_codInscrip}", nativeQuery = true)
	public String GenerarCodigoInst();
}
