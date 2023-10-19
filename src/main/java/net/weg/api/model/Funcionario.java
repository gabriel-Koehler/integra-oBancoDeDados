package net.weg.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_funcionario")

public class Funcionario extends Usuario{

    private Double salario;
    private Integer matricula;
    private String cargo;
}
