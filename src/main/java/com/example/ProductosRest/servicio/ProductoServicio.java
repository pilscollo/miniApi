package com.example.ProductosRest.servicio;

import com.example.ProductosRest.modelo.Producto;
import com.example.ProductosRest.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio repositorio;

    public List<Producto> listarProductos() {
        return repositorio.findAll();
    }
    public void guardarProducto(Producto producto)
    {
        repositorio.save(producto);
    }

    public Producto obtenerProducto(Integer id)
    {

        return repositorio.findById(id).get();
    }

    public void eliminarProducto(Integer id)
    {
        repositorio.deleteById(id);
    }
    public Producto encontarProductopornombre(String nombre)
    {
        Producto productoAux = null;

        ArrayList<Producto> productos= (ArrayList<Producto>) repositorio.findAll();
        for (Producto producto : productos)
        {
            if(producto.getNombre().equals(nombre))
            {
                productoAux= producto;
            }
        }

        return productoAux;
    }
}
