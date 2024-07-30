package hn.unah.lenguajes.banco.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="direccion")
@Data
public class Direccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigodireccion")
    private long codigoDireccion;

    private String ciudad;

    private String departamento;

    private String calle;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Cliente cliente;

}
