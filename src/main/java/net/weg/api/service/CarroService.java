package net.weg.api.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarroService {
    private CarroRepository carroRepository;

    public void salvar(Carro carro) {
            carroRepository.save(carro);
    }

    public Carro buscar(Integer id) {
        return carroRepository.findById(id).get();
    }

    public Collection<Carro> buscarTodos() {
        return carroRepository.findAll();
    }

    public void deletar(Integer id) {
        carroRepository.deleteById(id);
    }
}
