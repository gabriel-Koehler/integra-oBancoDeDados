package net.weg.api.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.api.model.Usuario;
import net.weg.api.repository.UsuarioRespository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRespository usuarioRepository;

    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario buscar(Integer id) {
        Optional<Usuario> usuarioOptional= usuarioRepository.findById(id);
        Usuario usuario=usuarioOptional.get();

        return usuario;
    }

    public Collection<Usuario> buscarTodos() {
        return usuarioRepository.findAll();

    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
