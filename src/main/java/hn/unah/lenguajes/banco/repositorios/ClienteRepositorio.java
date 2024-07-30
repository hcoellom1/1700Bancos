package hn.unah.lenguajes.banco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.banco.modelos.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String>{
    
}
