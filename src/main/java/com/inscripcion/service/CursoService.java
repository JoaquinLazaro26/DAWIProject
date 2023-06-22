package com.inscripcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inscripcion.dao.CursoRepository;
import com.inscripcion.entity.Curso;

@Service
public class CursoService {
	@Autowired
	private CursoRepository repo;
	
	// JEFRYYYY
	// CONSULTA Y REPORTE POR COMBO PAIS
	public List<Curso> listarCursosPorCodigoCarrera(int cod) {
		return repo.listarCursosPorCodigoCarrera(cod);
	}
	
	
}
