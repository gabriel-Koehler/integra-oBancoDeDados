package net.weg.api.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.api.model.Seguradora;
import net.weg.api.model.Seguro;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/seguradora")

public class SeguradoraController {

    SeguradoraService seguradoraService;

    @GetMapping
    public Collection<Seguradora> buscarTodos(){
        return seguradoraService.buscarTodos();
    }
    @GetMapping("/{id}")
    public Seguradora buscarUm(@PathVariable Integer id){
        return seguradoraService.buscarUm(id);
    }

    @PostMapping
    public void salvar(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }
    @PutMapping
    public void atualizar(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }
}
