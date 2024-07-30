package hn.unah.lenguajes.banco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.lenguajes.banco.modelos.Direccion;

public interface DireccionRepositorio extends JpaRepository<Direccion, Long>{
    
}
