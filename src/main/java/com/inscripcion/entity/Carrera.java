package com.inscripcion.entity;

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
@Table(name = "tb_carrera")
public class Carrera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrera")
	private Integer codigo;
	@Column(name = "nom_carrera")
	private String nomCarrera;
	@Column(name = "ciclo_fac")
	private String ciclos;
	@Column(name = "creditos_fac")
	private int creditos;
	@Column(name = "costo")
	private double costo;

	// Witer
	@ManyToOne
	@JoinColumn(name = "cod_facultad")
	private Facultad Facultad;

	// RELACION UNO A MUCHOS
	@OneToMany(mappedBy = "tipoCarrera") // NOMBRE DE LA ASOCIACION
	@JsonIgnore
	private List<Inscripcion> listaInscripcion;

	@OneToMany(mappedBy = "Carrera")
	@JsonIgnore
	private List<Curso> listaCurso;

	
	
	public List<Curso> getListaCurso() {
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomCarrera() {
		return nomCarrera;
	}

	public void setNomCarrera(String nomCarrera) {
		this.nomCarrera = nomCarrera;
	}

	public String getCiclos() {
		return ciclos;
	}

	public void setCiclos(String ciclos) {
		this.ciclos = ciclos;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public List<Inscripcion> getListaInscripcion() {
		return listaInscripcion;
	}

	public void setListaInscripcion(List<Inscripcion> listaInscripcion) {
		this.listaInscripcion = listaInscripcion;
	}

	public Facultad getFacultad() {
		return Facultad;
	}

	public void setFacultad(Facultad facultad) {
		Facultad = facultad;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

}
