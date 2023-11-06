package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.repository.SeguradoraRepository;
import net.weg.api.repository.SeguroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
@Service
@AllArgsConstructor
public class SeguroService {
    private SeguroRepository seguroRepository;

    public void salvar(SeguroCadastroDTO seguroCadastroDTO){
        Seguro seguro = new Seguro();
        BeanUtils.copyProperties(seguroCadastroDTO,seguro);
        seguroRepository.save(seguro);
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
