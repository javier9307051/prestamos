package com.mx.Prestamos.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Prestamos.Service.PrestamoServiceImp;
import com.mx.Prestamos.dominio.Cliente;

@RestController
@RequestMapping("/Prestamo")
@CrossOrigin("*")
public class PrestamosWS {

	@Autowired
	private PrestamoServiceImp servicio;

	// http://localhost:8001/Prestamo/listar
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		List<Cliente> listaCliente = servicio.listar();
		if (!listaCliente.isEmpty()) {
			return ResponseEntity.ok(listaCliente);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

	}

	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@RequestBody Cliente cliente) {
		Cliente clienteAux = servicio.buscar(cliente);
		if (clienteAux == null) {
			servicio.guardar(cliente);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Cliente cliente) {
		Cliente clienteAux = servicio.buscar(cliente);
		if (clienteAux != null) {
			servicio.editar(clienteAux);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Cliente cliente) {
		Cliente clienteAux = servicio.buscar(cliente);
		if (clienteAux != null) {
			servicio.eliminar(cliente);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(path = "buscar")
	public ResponseEntity<?> buscar(@RequestBody Cliente cliente) {
		Cliente clienteAux = servicio.buscar(cliente);
		if (clienteAux != null) {
			return ResponseEntity.ok(clienteAux);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping(path = "prestamo")
	public ResponseEntity<?> prestamo(@RequestBody Cliente cliente) {
		Cliente clienteAux = servicio.buscar(cliente);
		if (clienteAux != null) {
			servicio.prestamo(cliente);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
