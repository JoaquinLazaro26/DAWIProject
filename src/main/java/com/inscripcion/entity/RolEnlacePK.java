package com.inscripcion.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class RolEnlacePK implements Serializable{

	private int idrol, idenlace;

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public int getIdenlace() {
		return idenlace;
	}

	public void setIdenlace(int idenlace) {
		this.idenlace = idenlace;
	}

	//HashCode Genera un número según los atributos, el .equals valida que el número no se repita
	
	@Override
	public int hashCode() {
		return Objects.hash(idenlace, idrol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePK other = (RolEnlacePK) obj;
		return idenlace == other.idenlace && idrol == other.idrol;
	}
	
	
	
}
