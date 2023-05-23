package com.inscripcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inscripcion.dao.FacultadRepository;
import com.inscripcion.entity.Facultad;

@Service
public class FacultadService {

	@Autowired	
	private  FacultadRepository repo ;
	
	public List<Facultad> ListarFacultades(){
		return repo.findAll();
	}
}
