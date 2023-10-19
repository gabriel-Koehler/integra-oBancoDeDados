package net.weg.api.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.repository.SeguroRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data

public class SeguroService {

    SeguroRepository seguroRepository;

    public Collection<Seguro> buscarTodos(){
        return seguroRepository.findAll();
    }

    public Seguro buscarUm(Integer id){
        Optional<Seguro> seguro  = seguroRepository.findById(id);
        return seguro.get();
    }

    public void salvar(Seguro seguro){
        seguroRepository.save(seguro);
    }
}
