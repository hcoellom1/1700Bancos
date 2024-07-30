package hn.unah.lenguajes.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.banco.modelos.Productos;
import hn.unah.lenguajes.banco.repositorios.ClienteRepositorio;
import hn.unah.lenguajes.banco.repositorios.ProductoRepositorio;

@Service
public class ProductoServicio {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;


    public Productos crearProducto(String dni, Productos nvoProducto){        
        if(this.clienteRepositorio.existsById(dni)){
            nvoProducto.setCliente(this.clienteRepositorio.findById(dni).get());
            return this.productoRepositorio.save(nvoProducto);
        }

        return null;
    }

    public String eliminarProducto(String dni, long codigoProducto){
        if(this.clienteRepositorio.existsById(dni)){
            List<Productos> productosCliente = this.clienteRepositorio.findById(dni).get().getProductos();

            for(Productos producto: productosCliente){
                if(producto.getCodigoProducto()==codigoProducto){
                    this.productoRepositorio.delete(producto);
                    return "Se ha eliminado el producto";
                }
            }

        }

        //Elimina producto sin importar a quien pertenezca
        if(productoRepositorio.existsById(codigoProducto)){
            this.productoRepositorio.deleteById(codigoProducto);
        }

        return "No se ha encontrado el producto";
    }

}
