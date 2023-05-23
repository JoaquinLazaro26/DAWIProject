package com.inscripcion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inscripcion.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{

}
