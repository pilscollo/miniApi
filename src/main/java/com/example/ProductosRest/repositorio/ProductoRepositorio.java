package com.example.ProductosRest.repositorio;

import com.example.ProductosRest.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto,Integer>{
}
