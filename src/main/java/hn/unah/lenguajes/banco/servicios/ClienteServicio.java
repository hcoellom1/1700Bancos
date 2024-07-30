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

    @Autowired
    private DireccionRepositorio direccionRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Cliente> obtenerTodos(){
        return this.clienteRepositorio.findAll();
    }

    public Cliente crearCliente(Cliente nvoCliente){
        Cliente clienteGuardar = this.clienteRepositorio.save(nvoCliente);
        this.clienteRepositorio.save(clienteGuardar);

        Direccion nvaDireccion = nvoCliente.getDireccion();
        nvaDireccion.setCliente(clienteGuardar);
        this.direccionRepositorio.save(nvaDireccion);

        for(Productos nvoProducto:nvoCliente.getProductos()){
            nvoProducto.setCliente(clienteGuardar);
            this.productoRepositorio.save(nvoProducto);
        }

        return clienteGuardar;
    }

    public boolean buscarPorIdentidad(String identidad){
        return this.clienteRepositorio.existsById(identidad);
    }
}
