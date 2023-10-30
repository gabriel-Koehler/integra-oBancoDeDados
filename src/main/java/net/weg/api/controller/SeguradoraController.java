package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.model.Seguradora;
import net.weg.api.service.CarroService;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/seguradora")
public class SeguradoraController {

    private SeguradoraService seguradoraService;

    @GetMapping("/{id}")
    public Seguradora buscarUsuario(@PathVariable Integer id){
        return seguradoraService.buscarUm(id);
    }

    @GetMapping
    public Collection<Seguradora> buscarTodos(){
        return seguradoraService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        seguradoraService.deletar(id);
    }

    @PostMapping
    public void inserir(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }

    @PutMapping
    public void atualizar(@RequestBody Seguradora seguradoraAtualizada){
        seguradoraService.salvar(seguradoraAtualizada);
    }
}
