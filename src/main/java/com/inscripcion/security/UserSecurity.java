package com.inscripcion.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inscripcion.entity.Usuario;
import com.inscripcion.service.UsuarioService;
@Service
public class UserSecurity implements UserDetailsService{
	@Autowired
	private UsuarioService service;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails datos =null;
		//Invocaar al método para validar usuario
		Usuario bean = service.validarSesion(username);
		//Rol del usuario
		Set<GrantedAuthority> rol = new HashSet<GrantedAuthority>();
		//Adicionar rol al usuario
		rol.add(new SimpleGrantedAuthority(bean.getRol().getDescripcion()));
		//Crear objeto datos
		datos = new User(username, bean.getClave(), rol);
		return datos;
	}

}
