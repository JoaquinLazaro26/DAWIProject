package com.inscripcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inscripcion.dao.OrdenPagoRepository;
import com.inscripcion.entity.OrdenPago;

@Service
public class OrdenPagoService {
	@Autowired
	private OrdenPagoRepository repo;
	
	public List<OrdenPago> listarOrdenPago(){
		return repo.findAll();
	}
	
	public void grabar(OrdenPago o) {
		repo.save(o);
	}
	public void eliminar(String cod) {
		repo.deleteById(cod);
	}
	public OrdenPago buscarPorCodigo(String cod) {
		return repo.findById(cod).orElse(null);
	}
}
