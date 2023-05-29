package com.inscripcion;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inscripcion.entity.Alumno;
import com.inscripcion.service.AlumnoService;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private AlumnoService servicio;

	@Test
	void contextLoads() {
		
		List<Alumno> data = servicio.consultaPorApellidoAlumno("Lazaro");
		for (Alumno a : data)
			System.out.println(a.getApeAlumno());

	}

}
