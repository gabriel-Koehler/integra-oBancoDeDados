package net.weg.api.service;


import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;
import net.weg.api.model.Seguradora;
import net.weg.api.repository.SeguradoraRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SeguradoraService {

    private SeguradoraRepository seguradoraRepository;

    public void salvar(Seguradora seguradora){

        seguradoraRepository.save(seguradora);
    }

    public void deletar(Integer id) {
        seguradoraRepository.deleteById(id);
    }

    public Seguradora buscarUm(Integer id) {
        Optional<Seguradora> seguradoraOptional= seguradoraRepository.findById(id);
        Seguradora seguradora= seguradoraOptional.get();
        return seguradora;
    }

    public Collection<Seguradora> buscarTodos() {
        return seguradoraRepository.findAll();
    }
}
