package net.weg.api.controller;

import net.weg.api.model.Carro;
import net.weg.api.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/carro")
public class CarroController {
    private CarroService carroService=new CarroService();

    @GetMapping("/{id}")
    public Carro buscar(@PathVariable Integer id){
        return carroService.buscar(id);
    }

    @GetMapping()
    public Collection<Carro> buscarTodos(){
        return carroService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        carroService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Carro carro){
        carroService.inserir(carro);
    }

    @PutMapping()
    public void atualizar(@RequestBody Carro carro){
        carroService.atualizar(carro);
    }
}
