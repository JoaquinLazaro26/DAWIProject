package com.inscripcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inscripcion.dao.CarreraRepository;
import com.inscripcion.entity.Carrera;

@Service
public class CarreraService {
	@Autowired
	private CarreraRepository repo;
	
	// J
	public List<Carrera> listarCarreras() {
		return repo.findAll();
	}
	
	// W
	public void registrar(Carrera bean) {
		repo.save(bean);
		
	}
		
	public List<Carrera> ListarCarreras(){
		return repo.findAll();
	}
		
		
	public void actualizar(Carrera m) {
		repo.save(m);
	}
		
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	
	public Carrera buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
}
