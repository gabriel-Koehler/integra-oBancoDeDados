package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/seguradora")
public class SeguradoraController {
    private SeguradoraService seguradoraService;

    @PostMapping
    public void inserir(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }

    @PutMapping
    public void atualizar(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }

    @DeleteMapping("/{id}")
    public void deletar(Integer id){
        seguradoraService.deletar(id);
    }

    @GetMapping()
    public Collection<Seguradora> buscarTodos(){
        return seguradoraService.buscarTodos();
    }
}
