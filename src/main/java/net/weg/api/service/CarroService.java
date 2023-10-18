package net.weg.api.service;

import net.weg.api.model.Carro;
import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAD;
import net.weg.api.repository.UsuarioDAD;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class CarroService {
    private CarroDAD carroDAD;

    public CarroService()  {
        this.carroDAD = new CarroDAD();
    }
    public void inserir(Carro carro) {
        try {
            carroDAD.buscar(carro.getId());
        } catch (NoSuchElementException e) {
            carroDAD.inserir(carro);
        }
    }

    public Carro buscar(Integer id) {
        return carroDAD.buscar(id);
    }

    public Collection<Carro> buscarTodos() {
        return carroDAD.buscarTodos();
    }

    public void deletar(Integer id) {
        carroDAD.deletar(id);
    }

    public void atualizar(Carro carro) {
        carroDAD.atualizar(carro);
    }
}
