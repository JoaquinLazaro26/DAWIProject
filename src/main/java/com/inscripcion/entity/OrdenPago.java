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
@Table(name="tb_comprobante_pago")
public class OrdenPago {
	@Id
	@Column(name = "id_compago")
	private String codigo;
	@Column(name = "fecha_comp")
	private LocalDate fecha;
	@Column(name = "monto_comp")
	private double monto;
	@Column(name = "estado_comp")
	private String estado;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_inscripcion")
	private Inscripcion inscripciones;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Inscripcion getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(Inscripcion inscripciones) {
		this.inscripciones = inscripciones;
	}



	
	
}
