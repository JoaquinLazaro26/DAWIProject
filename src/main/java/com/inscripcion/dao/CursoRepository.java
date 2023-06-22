package com.inscripcion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inscripcion.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

	@Query("select e from Curso e where e.Carrera.codigo=?1")
	public List<Curso> listarCursosPorCodigoCarrera(int codigo);
}
