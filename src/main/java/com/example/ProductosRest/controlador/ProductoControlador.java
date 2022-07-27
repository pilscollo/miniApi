package com.example.ProductosRest.controlador;

import com.example.ProductosRest.modelo.Producto;
import com.example.ProductosRest.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoControlador {
    @Autowired
    private ProductoServicio servicio;

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return servicio.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id)
    {
        try{
            Producto producto = servicio.obtenerProducto(id);
            return  new ResponseEntity<Producto>(producto,HttpStatus.OK);
        }catch (Exception e)
        {
            return  new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/productos")
    public void guardarProducto(@RequestBody Producto producto)
    {
        if(servicio.encontarProductopornombre(producto.getNombre())==null)
        {
            servicio.guardarProducto(producto);
        }
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto,@PathVariable Integer id)
    {
        try {
            Producto productoExistente= servicio.obtenerProducto(id);
            if(servicio.encontarProductopornombre(producto.getNombre())==null)
            {
                productoExistente.setNombre(producto.getNombre());
            }
            productoExistente.setPrecio(producto.getPrecio());
            servicio.guardarProducto(productoExistente);
            return  new ResponseEntity<Producto>(HttpStatus.OK);

        }catch(Exception e)
        {
            return  new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id)
    {
        if(servicio.obtenerProducto(id)!=null)
        {
            servicio.eliminarProducto(id);
        }

    }



}
