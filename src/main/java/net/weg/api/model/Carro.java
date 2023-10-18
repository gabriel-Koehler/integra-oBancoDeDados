package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tb_carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marca;
    private String cor;
    @Column(unique = true)
    private String modelo;
    private Double preco;
    private Integer ano;

}
