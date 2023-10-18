package net.weg.api.service;

import net.weg.api.model.Carro;
import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAD;
import net.weg.api.repository.UsuarioDAD;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {
    private UsuarioDAD usuarioDAD;
    private CarroService carroService=new CarroService();

    public UsuarioService(){
        usuarioDAD=new UsuarioDAD();
    }

    public void inserir(Usuario usuario) {

        try {
            carroService.buscar(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroService.inserir(usuario.getCarro());
        }
        usuarioDAD.inserir(usuario);
    }

    public Usuario buscar(Integer id) {
        return usuarioDAD.buscar(id);
    }

    public Collection<Usuario> buscarTodos() {
        Collection<Usuario>usuarios=usuarioDAD.buscarTodos();

        return usuarios;
    }

    public void deletar(Integer id) {
        usuarioDAD.deletar(id);
    }

    public void atualizar(Usuario usuario) {

        usuarioDAD.atualizar(usuario);
    }
}
