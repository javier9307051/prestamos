package com.mx.Prestamos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Prestamos.dominio.Cliente;

@Repository
public interface PrestamoDao extends JpaRepository<Cliente, Integer>{

}
