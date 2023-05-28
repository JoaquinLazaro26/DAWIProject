package com.inscripcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inscripcion.dao.InscripcionesRepository;
import com.inscripcion.entity.Inscripcion;

@Service
public class InscripcionesService {
	@Autowired
	private InscripcionesRepository repo;
	
	public List<Inscripcion> listarInscripciones() {
		return repo.findAll();
	}
	
	public void registrar(Inscripcion i) {
		repo.save(i);
	}
	
	public void actualizar(Inscripcion i) {
		repo.save(i);
	}
	
	public Inscripcion buscarPorID(String cod) {
		return repo.findById(cod).orElse(null);
	}
	public Inscripcion buscarInscripcionesPorEstado(String estado)
	{
		return repo.buscarInscripcionEstado(estado);
	}
	
	public String GenerarCodigo() {
		return repo.GenerarCodigoInst();
	}
	
	
}
