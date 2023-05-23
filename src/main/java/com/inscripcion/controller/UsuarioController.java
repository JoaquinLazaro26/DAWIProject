package com.inscripcion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.core.io.Resource;

import com.inscripcion.service.UsuarioService;
import com.inscripcion.entity.Enlace;
import com.inscripcion.entity.Usuario;
@SessionAttributes({"datosUsuario","ENLACES"})
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService servicio;
	//
	@Autowired
    private ResourceLoader resourceLoader;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/principal")
	public String index(Authentication auth, Model x) {

		String vLogin = auth.getName();
		//Invocar al método validar sesión
		Usuario bean = servicio.validarSesion(vLogin);
		//Invocar al método enlaces del usuario
		List<Enlace> lista = servicio.retornarEnlacesUsuario(bean.getRol().getCodigo());
		//Asignar valor a los atributos de tipo sesión
		x.addAttribute("datosUsuario",bean.getApellido()+" "+bean.getNombre());
		x.addAttribute("ENLACES", lista);
		
		
		
		return "principal";
	}
	//

    @GetMapping("/resources/**")
    public ResponseEntity<Resource> getResource() {
        String resourcePath = "classpath:/static" + "/resources/"; // Obtén la ruta del recurso específico que necesites

        Resource resource = resourceLoader.getResource(resourcePath);

        // Lógica adicional según tus necesidades, como leer o manipular el recurso

        return ResponseEntity.ok().body(resource);
    }
}
