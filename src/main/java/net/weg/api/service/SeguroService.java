package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroId;
import net.weg.api.repository.SeguroRepository;
import net.weg.api.view.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguroService implements IService {
    private SeguroRepository seguroRepository;

    public void salvar(SeguroCadastroDTO seguroCadastroDTO){
        Seguro seguro = new Seguro();
        BeanUtils.copyProperties(seguroCadastroDTO,seguro);
        seguroRepository.save(seguro);
    }

    public void deletar(Integer id, Integer seguradoraId){
        seguroRepository.deleteById(new SeguroId(id,seguradoraId));
    }

    public Seguro buscarUm(Integer id, Integer seguradoraId){
        return seguroRepository.findById(new SeguroId(id,seguradoraId)).get();
    }

    public List<Seguro> buscarTodos(){
        return seguroRepository.findAll();
    }

}
