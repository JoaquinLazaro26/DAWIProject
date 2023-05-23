package com.inscripcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inscripcion.dao.PaisRepository;
import com.inscripcion.entity.Pais;

@Service
public class PaisServices {
	@Autowired
	private PaisRepository repo;
	
	public List<Pais>listarTodos(){
		return repo.findAll();
	}
	

}
