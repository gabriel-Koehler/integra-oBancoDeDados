package net.weg.api.repository;

import net.weg.api.model.Carro;
import net.weg.api.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAD extends DADpadrao<Usuario,Integer>{

    public UsuarioDAD(){
        super("usuario");
    }

    @Override
    public void inserir(Usuario objeto) {
        setComandoSQL(
                "Insert Into Usuario Values(?,?,?,?,?);");
        try (PreparedStatement statement = getConnection().prepareStatement(getComandoSQL())){
            //faz primeiro a preparaçao  do comondo
            statement.setInt(1,objeto.getId());
            statement.setString(2,objeto.getNome());
            statement.setString(3,objeto.getSenha());
            statement.setInt(4,objeto.getIdade());

            try {
                Carro carro= objeto.getCarro();
                statement.setInt(5,carro.getId());
            } catch (NullPointerException e) {
                statement.setNull(5,0);
            }
            // não executar mais o
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Usuario converter(ResultSet resultSet) throws SQLException {
        return new Usuario(resultSet);
    }

    @Override
    public void atualizar(Usuario objeto) {
        super.conectar();
        setComandoSQL("update usuario set nome=?,senha=?,idade=?,id_carro=? where id=?;");
        try (PreparedStatement statement = connection.prepareStatement(getComandoSQL())){
            statement.setString(1, objeto.getNome());
            statement.setString(2,objeto.getSenha());
            statement.setInt(3,objeto.getIdade());
            try {
                Carro carro = objeto.getCarro();
                statement.setInt(
                        4,carro.getId()
                );
            }catch (NullPointerException e){
                statement.setNull( 4,0);
            }
            statement.setInt(5,objeto.getId());

            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
