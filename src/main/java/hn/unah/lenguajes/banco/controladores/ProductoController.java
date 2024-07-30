package hn.unah.lenguajes.banco.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.banco.modelos.Productos;
import hn.unah.lenguajes.banco.servicios.ProductoServicio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    
    @Autowired
    private ProductoServicio productoServicio;

    @PostMapping("/asociar/{dni}")
    public Productos postMethodName(@PathVariable(name="dni") String dni,
                                 @RequestBody Productos producto) {
        return this.productoServicio.crearProducto(dni, producto);
    }
    
    @DeleteMapping("/eliminar/{dni}/{producto}")
    public String eliminarProducto(@PathVariable(name="dni") String dni,
                                   @PathVariable(name="producto") long producto){
        return this.productoServicio.eliminarProducto(dni, producto);
    }

}
