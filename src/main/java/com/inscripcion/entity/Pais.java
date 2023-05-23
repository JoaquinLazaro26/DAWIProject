package com.inscripcion.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_pais")
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="cod_pais")
	private Integer codPais;
	
	@Column(name="nom_pais")
	private String namePais;
	
	@OneToMany(mappedBy = "pais")//nOMBRE DE LA VARIABLE
	@JsonIgnore
	private List<Alumno> listaAlumnos;

	public Integer getCodPais() {
		return codPais;
	}

	public void setCodPais(Integer codPais) {
		this.codPais = codPais;
	}

	public String getNamePais() {
		return namePais;
	}

	public void setNamePais(String namePais) {
		this.namePais = namePais;
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	
	

	


	
	
	
}
