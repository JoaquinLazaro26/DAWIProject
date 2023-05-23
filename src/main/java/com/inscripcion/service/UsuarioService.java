package com.inscripcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inscripcion.dao.UsuarioRepository;
import com.inscripcion.entity.Enlace;
import com.inscripcion.entity.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuRepo;
	
	public Usuario validarSesion(String vLogin) {
		return usuRepo.iniciarSesion(vLogin);
	}
	public List<Enlace> retornarEnlacesUsuario(int codigo){
		return usuRepo.retornarEnlaces(codigo);
	}
}
