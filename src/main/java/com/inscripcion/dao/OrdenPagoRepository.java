package com.inscripcion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inscripcion.entity.OrdenPago;

public interface OrdenPagoRepository extends JpaRepository<OrdenPago, String>{
	@Query(value="{call sp_generar_codBoleta}", nativeQuery = true)
	public String GenerarCodigoPago();
	
	@Query("select e from OrdenPago e where month(e.fecha)=?1")
	public List<OrdenPago> listarOrdenesPagoPorMesYaño(int mes);
	
}
