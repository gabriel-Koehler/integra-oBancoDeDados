package net.weg.api.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.api.model.Seguro;
import net.weg.api.service.SeguroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/seguro")
public class SeguroController {

    SeguroService seguroService;

    @GetMapping
    public Collection<Seguro> buscarTodos(){
        return seguroService.buscarTodos();
    }
    @GetMapping("/{id}")
    public Seguro buscarUm(@PathVariable Integer id){
         return seguroService.buscarUm(id);
    }

    @PostMapping
    public void salvar(@RequestBody Seguro seguro){
        seguroService.salvar(seguro);
    }
    @PutMapping
    public void atualizar(@RequestBody Seguro seguro){
        seguroService.salvar(seguro);
    }

}
