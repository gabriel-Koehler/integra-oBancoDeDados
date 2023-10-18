package net.weg.api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class DADpadrao<T,ID> implements ICRUD<T,ID> {
    protected Connection connection;
    protected String comandoSQL;
    private String tabela;

    public DADpadrao(String tabela) {
        this.tabela=tabela;
    }

    public void conectar(){
        this.connection = Banco.conectar();
    }

    public Connection getConnection() {
        return connection;
    }

    public String getComandoSQL() {
        return comandoSQL;
    }

    public void setComandoSQL(String comandoSQL) {
        this.comandoSQL = comandoSQL;
    }

    @Override
    public Set<T> buscarTodos() {
        setComandoSQL("Select * from "+this.tabela+";");

        try
                (PreparedStatement statement = getConnection().prepareStatement(getComandoSQL());)
        {
            ResultSet resultSet = statement.executeQuery(getComandoSQL());
            Set<T> setListUsuarios = new HashSet<>();
            //.next verifica se tem um  proximo objeto, pois sempre o primeiro é null
            // logo retorna boolean, e muda o objeto se existir um proximo
            while (resultSet.next()) {
                setListUsuarios.add(converter(resultSet));
            }
            return setListUsuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public abstract T converter(ResultSet resultSet) throws SQLException;

    public void deletar(Integer integer) {
        conectar();
        setComandoSQL("DELETE FROM "+tabela+" where id= ?");
        try (PreparedStatement statement = getConnection().prepareStatement(getComandoSQL());){
            statement.setInt(1,integer);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public T buscar(Integer integer) {
        conectar();
        setComandoSQL("select * FROM "+tabela+" where id= ?");
        try (PreparedStatement statement = getConnection().prepareStatement(getComandoSQL());){
            statement.setInt(1,integer);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return converter(resultSet);
            }
            throw new NoSuchElementException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
