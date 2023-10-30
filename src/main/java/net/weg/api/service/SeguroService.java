package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.repository.SeguradoraRepository;
import net.weg.api.repository.SeguroRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
@Service
@AllArgsConstructor
public class SeguroService {
    private SeguroRepository seguroRepository;

    public void salvar(Seguro seguro){
        seguroRepository.save(seguro);
    }

    public void deletar(Integer id) {
        seguroRepository.deleteById(id);
    }

    public Seguro buscarUm(Integer id) {
        Optional<Seguro> seguradoraOptional= seguroRepository.findById(id);
        Seguro seguro= seguradoraOptional.get();
        return seguro;
    }

    public Collection<Seguro> buscarTodos() {
        return seguroRepository.findAll();
    }
}
