package net.weg.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marca;
    private String cor;
    private String modelo;
    private double preco;
    private Integer ano;
    @OneToOne(mappedBy = "carro")
    @JsonIgnore
    private Seguro seguro;

}
