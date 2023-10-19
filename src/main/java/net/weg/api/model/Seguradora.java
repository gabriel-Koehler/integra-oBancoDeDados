package net.weg.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_seguradora")

public class Seguradora {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private  Integer id;
    private Long cpnj;
    private String nome;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;
    @ManyToMany
    @JsonIgnore
    //não vai retornar esse atributo, vai ser ignorado
    private Set<Cliente> clientes;


}
