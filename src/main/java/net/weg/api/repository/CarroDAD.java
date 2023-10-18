package net.weg.api.repository;

import net.weg.api.model.Carro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDAD extends DADpadrao<Carro,Integer>{

    public CarroDAD() {
        super("carro");
    }

    @Override
    public void inserir(Carro objeto) {
        super.conectar();
        String comandoSql="insert into carro values(?,?,?,?,?,?);";
        try {
            PreparedStatement statement= connection.prepareStatement(comandoSql);
            statement.setInt(1,objeto.getId());
            statement.setString(2,objeto.getMarca());
            statement.setString(3,objeto.getModelo());
            statement.setInt(4,objeto.getAno());
            statement.setString(5,objeto.getCor());
            statement.setDouble(6,objeto.getPreco());
            // não executar mais o
            statement.execute();

        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public Carro converter(ResultSet resultSet) throws SQLException {
        return new Carro(resultSet);
    }

    @Override
    public void atualizar(Carro objeto) {
        super.conectar();
        String comandoSql="update carro set marca=? where id=?;";
        try (PreparedStatement statement= connection.prepareStatement(comandoSql)){
            statement.setInt(1,objeto.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
