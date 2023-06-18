package com.inscripcion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cur")
	private Integer codigo;
	@Column(name = "nom_curso")
	private String nombre;
	@Column(name = "credito")
	private int credito;

	// Witer
	@ManyToOne
	@JoinColumn(name = "id_carrera")
	private Carrera Carrera;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}

	public Carrera getCarrera() {
		return Carrera;
	}

	public void setCarrera(Carrera carrera) {
		Carrera = carrera;
	}

}
