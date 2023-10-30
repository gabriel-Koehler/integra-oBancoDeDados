package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;
import net.weg.api.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/{id}")
    public Cliente buscarUsuario(@PathVariable Integer id){
        return clienteService.buscarUm(id);
    }

    @GetMapping
    public Collection<Cliente> buscarTodos(){
        return clienteService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        clienteService.deletar(id);
    }

    @PostMapping
    public void inserir(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
    }

    @PutMapping
    public void atualizar(@RequestBody Cliente clienteAtualizado){
        clienteService.salvar(clienteAtualizado);
    }

}
