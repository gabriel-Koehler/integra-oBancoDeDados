package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.repository.SeguradoraRepository;
import net.weg.api.view.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguradoraService implements IService {
    private SeguradoraRepository seguradoraRepository;

    public void salvar(Seguradora seguradora){
        seguradoraRepository.save(seguradora);
    }

    public void deletar(Integer id){
        seguradoraRepository.deleteById(id);
    }

    public Seguradora buscarUm(Integer id){
        return seguradoraRepository.findById(id).get();
    }

    public List<Seguradora> buscarTodos(){
        return seguradoraRepository.findAll();
    }

}
