package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
// identificar com entinty
@Entity
@Table(name="tb_cliente")
public class Cliente extends Usuario {
    // identificar com id para o JPA mapear

    // primeiro  referencia sobre a classe manipulada
    @OneToMany
    // cascade cascadeType.persist serve para inserir em cascada um atributo po outro, no caso

    private Set<Carro> carro;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Endereco> endereco;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    //para não criar atributos duplos
    // sempre no OneToMany colocar o mappedBy
    @OneToMany(mappedBy = "cliente")
    private Set<Seguro> seguros;


}
