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
@Table(name="tb_usuarios")
public class Usuario {
    // identificar com id para o JPA mapear
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="username",unique = true,nullable = false)
    private String nome;
    private String senha;
    private Integer idade;
    // primeiro  referencia sobre a classe manipulada
    @OneToMany(cascade = CascadeType.PERSIST)
    //
    private Set<Carro> carro;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Endereco> endereco;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @ManyToOne
    private Consorcio consorcio;

}
