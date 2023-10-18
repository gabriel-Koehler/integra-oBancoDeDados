package net.weg.api.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private Integer id;
    private String nome;
    private String senha;
    private Integer idade;
    private Carro carro;

    public Usuario(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.nome = resultSet.getString("nome");
        this.senha = resultSet.getString("senha");
        this.idade = resultSet.getInt("idade");
        int id_carro=resultSet.getInt("id_carro");
        if (id_carro!=0) {
            this.carro = new Carro(resultSet.getInt("id_carro"));
        }
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nUsuario{" +
                "id=" + id +'\n'+
                ", nome='" + nome + '\n' +
                ", senha='" + senha + '\n' +
                ", idade=" + idade +
                '}';
    }
}
