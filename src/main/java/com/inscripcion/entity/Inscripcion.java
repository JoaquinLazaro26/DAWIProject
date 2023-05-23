package com.inscripcion.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_inscripcion")
public class Inscripcion {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_inscripcion")
	private String codigo;
	@Column(name="fecha_inscripcion")
	private LocalDate fechaIns;
	@Column(name="estado_insc")
	private String estado;
	
	
	@OneToMany(mappedBy = "inscripciones")
	@JsonIgnore
	private List<OrdenPago> listaordenpago;
	
	
	//BI-DIRECIONAL
	//MUCHOS A UNO
	@ManyToOne
	@JoinColumn(name="id_carrera")
	private Carrera tipoCarrera; // "" --> ASOCIACION ENTRE ENTIDADES
	
	//BI-DIRECIONAL
	//MUCHOS A UNO
	@ManyToOne
	@JoinColumn(name="id_alu")
	private Alumno dniSAlumno; // "" --> ASOCIACION ENTRE ENTIDADES

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFechaIns() {
		return fechaIns;
	}

	public void setFechaIns(LocalDate fechaIns) {
		this.fechaIns = fechaIns;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Carrera getTipoCarrera() {
		return tipoCarrera;
	}

	public void setTipoCarrera(Carrera tipoCarrera) {
		this.tipoCarrera = tipoCarrera;
	}

	public Alumno getDniSAlumno() {
		return dniSAlumno;
	}

	public void setDniSAlumno(Alumno dniSAlumno) {
		this.dniSAlumno = dniSAlumno;
	}

	public List<OrdenPago> getListaordenpago() {
		return listaordenpago;
	}

	public void setListaordenpago(List<OrdenPago> listaordenpago) {
		this.listaordenpago = listaordenpago;
	}

	

	
	
}
