package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;

import net.weg.api.repository.ClienteRepository;

import org.springframework.stereotype.Service;

import java.util.Collection;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository usuarioRepository;

    public void salvar(Cliente cliente){

        usuarioRepository.save(cliente);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Cliente buscarUm(Integer id) {
        Optional <Cliente> usuarioOptional= usuarioRepository.findById(id);
        Cliente cliente= usuarioOptional.get();
        return cliente;
    }

    public Collection<Cliente> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
