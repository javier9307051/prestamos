package com.mx.Prestamos.Service;

import java.util.List;

import com.mx.Prestamos.dominio.Cliente;

public interface PrestamoService {
	public void guardar(Cliente cliente);

	public void editar(Cliente cliente);

	public void eliminar(Cliente cliente);

	public Cliente buscar(Cliente cliente);

	public List<Cliente> listar();
	
	public void prestamo(Cliente cliente);

}
