package net.weg.api.controller;

import net.weg.api.model.Usuario;
import net.weg.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    UsuarioService usuarioService;

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Integer id){
        return usuarioService.buscar(id);
    }

    @GetMapping()
    public Collection<Usuario> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        usuarioService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Usuario usuario){
        usuarioService.inserir(usuario);
    }

    @PutMapping()
    public void atualizar(@RequestBody Usuario usuario){
        usuarioService.atualizar(usuario);
    }
}
