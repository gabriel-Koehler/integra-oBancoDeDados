package net.weg.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(SeguroidClass.class)
public class Seguro {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

    //Primeiro Exemplo de como criar uma chave composta
//    @EmbeddedId
//    private SeguroId id;

    //Segundo exemplo de criar uma chave composta
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seguroId;
    @Id
    private Integer seguradoraIdClass;

    private Double valor;
    private String nome;
    private String descricao;
    private Double valorFranquia;
    @ManyToOne
//    @MapsId("seguradoraId")
    @JoinColumn(name = "seguradoraIdClass")
    private Seguradora seguradora;
    @OneToOne
    @JsonIgnore
    private Carro carro;
    @ManyToOne
    @JsonIgnore
    private Cliente cliente;
}
