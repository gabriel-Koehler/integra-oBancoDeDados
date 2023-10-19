package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;
import net.weg.api.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Integer id){
        return clienteService.buscar(id);
    }

    @GetMapping()
    public Collection<Cliente> buscarTodos(){
        return clienteService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        clienteService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
    }

    @PutMapping()
    public void atualizar(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
    }
}
