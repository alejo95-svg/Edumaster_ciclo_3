/*package com.edumaster.co.modelo;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "registro")
public class Registro {
	@EmbeddedId
	private BigInteger Id_usuario;
	private Integer Id_capacitacion;
	@Basic
	private Date Fecha;
	private Time Hora_inicio;
	private Time Hora_fin;
	
	public Registro() {
		
	}

	public Registro(BigInteger id_usuario, Integer id_capacitacion, Date fecha, Time hora_inicio, Time hora_fin) {
		super();
		Id_usuario = id_usuario;
		Id_capacitacion = id_capacitacion;
		Fecha = fecha;
		Hora_inicio = hora_inicio;
		Hora_fin = hora_fin;
	}

	public BigInteger getId_usuario() {
		return Id_usuario;
	}

	public void setId_usuario(BigInteger id_usuario) {
		Id_usuario = id_usuario;
	}

	public Integer getId_capacitacion() {
		return Id_capacitacion;
	}

	public void setId_capacitacion(Integer id_capacitacion) {
		Id_capacitacion = id_capacitacion;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public Time getHora_inicio() {
		return Hora_inicio;
	}

	public void setHora_inicio(Time hora_inicio) {
		Hora_inicio = hora_inicio;
	}

	public Time getHora_fin() {
		return Hora_fin;
	}

	public void setHora_fin(Time hora_fin) {
		Hora_fin = hora_fin;
	}

}*/
