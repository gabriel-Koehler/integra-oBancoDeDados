package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {


        private CarroService carroService;

        @GetMapping("/{id}")
        public Carro buscarUsuario(@PathVariable Integer id){
            return carroService.buscarUm(id);
        }

        @GetMapping
        public Collection<Carro> buscarTodos(){
            return carroService.buscarTodos();
        }

        @DeleteMapping("/{id}")
        public void deletar(@PathVariable Integer id){
            carroService.deletar(id);
        }

        @PostMapping
        public void inserir(@RequestBody Carro carro){
            carroService.salvar(carro);
        }

        @PutMapping
        public void atualizar(@RequestBody Carro carroAtualizado){
            carroService.salvar(carroAtualizado);
        }

        @GetMapping("/{modelo}")
        public List<Carro> buscarmodelo(@PathVariable String modelo){return carroService.buscarModelo(modelo);}
}
