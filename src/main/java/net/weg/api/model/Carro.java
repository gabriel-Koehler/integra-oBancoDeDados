package net.weg.api.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carro {

    private Integer id;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;

    public Carro(ResultSet resultSet) throws SQLException {
                this.id=resultSet.getInt("id");
                this.marca=resultSet.getString("marca");
                this.modelo=resultSet.getString("modelo");
                this.cor=resultSet.getString("cor");
                this.preco=resultSet.getDouble("preco");
                this.ano=resultSet.getInt("ano");
    }

    public Carro(Integer id) {
        this.id = id;
    }

}
