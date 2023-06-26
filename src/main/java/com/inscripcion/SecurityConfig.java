package com.inscripcion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.inscripcion.security.UserSecurity;

//Clase de configuracion
@Configuration
//Habilitar seguridad
@EnableWebSecurity
//Habilitar método para la clave
@EnableMethodSecurity
public class SecurityConfig {
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/*http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/usuario/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();*/
		
		http.csrf().disable().authorizeHttpRequests().
			requestMatchers("/usuario/**","/static/**","resources/img/**","resources/css/**","/paginaPrincipal/**").permitAll().and().
			authorizeHttpRequests().requestMatchers("/alumno/**","/Carrera/**","/inscripcion/**","/ordenpago/**","/resources/**","/FichaInscripcion/**","/reportes/**").authenticated().and()
			.formLogin().loginPage("/usuario/login").defaultSuccessUrl("/usuario/principal");
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserSecurity();

	}
	@Bean
	public AuthenticationProvider autentificar() {
		DaoAuthenticationProvider salida = new DaoAuthenticationProvider();
		//Atributos al objeto salida
		salida.setUserDetailsService(userDetailsService());
		salida.setPasswordEncoder(encoder());
		return salida;
	}
}
