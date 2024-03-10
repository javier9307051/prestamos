package com.mx.Prestamos.dominio;
/*
 * CREATE TABLE PRESTAMOS_QUERY(
ID NUMBER PRIMARY KEY,
NOMBRE_CLIENTE NVARCHAR2(50),
APP NVARCHAR2(50),
FECHA_NACIMIENTO DATE, -- APARTIR DE SU FECHA DE NACIEMINTO CALCULAMOS LA DE EDAD 
EDAD NUMBER, ---> 30 AÑOS SE AUTORIZA EL PRESTAMO 
TIPO_PRESTAMO NVARCHAR2(50), --> NOMINA, GRUPAL, 
MONTO NUMBER, --> 30, 40 50
FECHA_PRESTAMO DATE,
FECHA_ABONO DATE,
ABONO NUMBER,
AUDEUDO NUMBER,
CHECK (TIPO_PRESTAMO IN('NOMINA','GRUPAL'))
);
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="PRESTAMOS_QUERY")
public class Cliente {
	
	@Id
	@Column
	private int id;
	
	@Column
	private String nombreCliente;
	
	@Column
	private String app;
	
	@Column
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column
	private int edad;
	
	@Column
	private String tipoPrestamo;
	
	@Column
	private int monto;
	
	@Column
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaPrestamo;
	
	@Column
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaAbono;
	
	@Column
	private int abono;
	
	@Column
	private int adeudo;

	public Cliente() {
		
	}

	public Cliente(int id, String nombreCliente, String app, Date fechaNacimiento, int edad, String tipoPrestamo,
			int monto, Date fechaPrestamo, Date fechaAbono, int abono, int adeudo) {
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.app = app;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.tipoPrestamo = tipoPrestamo;
		this.monto = monto;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaAbono = fechaAbono;
		this.abono = abono;
		this.adeudo = adeudo;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombreCliente=" + nombreCliente + ", app=" + app + ", fechaNacimiento="
				+ fechaNacimiento + ", edad=" + edad + ", tipoPrestamo=" + tipoPrestamo + ", monto=" + monto
				+ ", fechaPrestamo=" + fechaPrestamo + ", fechaAbono=" + fechaAbono + ", abono=" + abono + ", adeudo="
				+ adeudo + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTipoPrestamo() {
		return tipoPrestamo;
	}

	public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaAbono() {
		return fechaAbono;
	}

	
	public void setFechaAbono(Date fechaAbono) {
		this.fechaAbono = fechaAbono;
	}

	public int getAbono() {
		return abono;
	}

	public void setAbono(int abono) {
		this.abono = abono;
	}

	public int getAdeudo() {
		return adeudo;
	}

	public void setAdeudo(int adeudo) {
		this.adeudo = adeudo;
	}
}
