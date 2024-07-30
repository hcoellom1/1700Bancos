package hn.unah.lenguajes.banco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.lenguajes.banco.modelos.Productos;

public interface ProductoRepositorio extends JpaRepository<Productos, Long>{
    
}
