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
@Table(name="tb_alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_alu")
	private Integer codigo;
	@Column(name="nombre_alu")
	private String nomAlumno;
	@Column(name="apellido_alu")
	private String apeAlumno;
	@Column(name="fecha_nac")
	private LocalDate fecNacimiento;
	@Column(name="correo_alu")
	private String correoAlu;
	
	@ManyToOne
	@JoinColumn(name="cod_pais") //BD
	private Pais pais; //VARIABLE
	
	//RELACION UNO A MUCHOS
	@OneToMany(mappedBy = "dniSAlumno")// NOMBRE DE LA ASOCIACION
	@JsonIgnore
	private List<Inscripcion> listaInscripcion;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomAlumno() {
		return nomAlumno;
	}

	public void setNomAlumno(String nomAlumno) {
		this.nomAlumno = nomAlumno;
	}

	public String getApeAlumno() {
		return apeAlumno;
	}

	public void setApeAlumno(String apeAlumno) {
		this.apeAlumno = apeAlumno;
	}

	public LocalDate getFecNacimiento() {
		return fecNacimiento;
	}

	public void setFecNacimiento(LocalDate fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getCorreoAlu() {
		return correoAlu;
	}

	public void setCorreoAlu(String correoAlu) {
		this.correoAlu = correoAlu;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Inscripcion> getListaInscripcion() {
		return listaInscripcion;
	}

	public void setListaInscripcion(List<Inscripcion> listaInscripcion) {
		this.listaInscripcion = listaInscripcion;
	}

	
}
