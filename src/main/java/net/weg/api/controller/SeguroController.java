package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.service.CarroService;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/seguro")
public class SeguroController {

    private SeguroService seguroService;

    @GetMapping("/{id}")
    public Seguro buscarUsuario(@PathVariable Integer id){
        return seguroService.buscarUm(id);
    }

    @GetMapping
    public Collection<Seguro> buscarTodos(){
        return seguroService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        seguroService.deletar(id);
    }

    @PostMapping
    public void inserir(@RequestBody SeguroCadastroDTO seguroCadastroDTO){
        seguroService.salvar(seguroCadastroDTO);
    }

    @PutMapping
    public void atualizar(@RequestBody SeguroCadastroDTO seguroAtualizado){
        seguroService.salvar(seguroAtualizado);
    }
}
