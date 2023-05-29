package com.inscripcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inscripcion.dao.CiudadRepository;
import com.inscripcion.entity.Ciudad;

@Service
public class CiudadService {
	
	@Autowired
	private CiudadRepository repo;
	
	public List<Ciudad> listarPorPais(int codigoPais){
		return repo.listarPorPais(codigoPais);
	}
}
