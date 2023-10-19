package net.weg.api.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.repository.SeguradoraRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SeguradoraService {

    SeguradoraRepository seguradoraRepository;

    public Collection<Seguradora> buscarTodos(){
        return seguradoraRepository.findAll();
    }

    public Seguradora buscarUm(Integer id){
        return seguradoraRepository.findById(id).get();
    }

    public void salvar(Seguradora seguradora){
        seguradoraRepository.save(seguradora);
    }

}
