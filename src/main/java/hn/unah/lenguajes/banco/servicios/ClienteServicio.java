package hn.unah.lenguajes.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.banco.modelos.Cliente;
import hn.unah.lenguajes.banco.modelos.Direccion;
import hn.unah.lenguajes.banco.modelos.Productos;
import hn.unah.lenguajes.banco.repositorios.ClienteRepositorio;
import hn.unah.lenguajes.banco.repositorios.DireccionRepositorio;
import hn.unah.lenguajes.banco.repositorios.ProductoRepositorio;

@Service
public class ClienteServicio {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    

    public List<Cliente> obtenerTodos(){
        return this.clienteRepositorio.findAll();
    }

    public Cliente crearCliente(Cliente nvoCliente){

        Direccion nvaDireccion = nvoCliente.getDireccion();
        if(nvaDireccion != null){
            nvaDireccion.setCliente(nvoCliente);
        }
        

        List<Productos> productos = nvoCliente.getProductos();        
        if(productos!=null){
            for(Productos producto : productos){
                producto.setCliente(nvoCliente);
            }
        }

        return this.clienteRepositorio.save(nvoCliente);
     
        
    }



    public boolean buscarPorIdentidad(String identidad){
        return this.clienteRepositorio.existsById(identidad);
    }
}
