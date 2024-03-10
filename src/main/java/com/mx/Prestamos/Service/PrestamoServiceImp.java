package com.mx.Prestamos.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.mx.Prestamos.dao.PrestamoDao;
import com.mx.Prestamos.dominio.Cliente;

import ch.qos.logback.core.util.CachingDateFormatter;

@Service
public class PrestamoServiceImp implements PrestamoService {

	@Autowired
	private PrestamoDao dao;

	@Override
	public void guardar(Cliente cliente) {
		Date fechaActual = new Date();
		int edad = fechaActual.getYear() - cliente.getFechaNacimiento().getYear();
		cliente.setEdad(edad);
		dao.save(cliente);
	}

	@Override
	public void editar(Cliente cliente) {
		dao.save(cliente);
	}

	@Override
	public void eliminar(Cliente cliente) {
		dao.delete(cliente);

	}

	@Override
	public Cliente buscar(Cliente cliente) {

		return dao.findById(cliente.getId()).orElse(null);
	}

	@Override
	public List<Cliente> listar() {

		return dao.findAll();
	}

	@Override
	public void prestamo(Cliente cliente) {
		Cliente clienteAux = buscar(cliente);
		if ((cliente.getMonto() == 30000 || cliente.getMonto() == 40000 || cliente.getMonto() == 40000)
				&& clienteAux.getEdad() >= 30) {
			cliente.setEdad(clienteAux.getEdad());
			dao.save(cliente);
		}
	}

}
