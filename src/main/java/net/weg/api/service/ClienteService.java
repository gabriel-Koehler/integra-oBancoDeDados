package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;
import net.weg.api.repository.ClienteRespository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRespository clienteRepository;

    public void salvar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente buscar(Integer id) {
        Optional<Cliente> usuarioOptional= clienteRepository.findById(id);
        return usuarioOptional.get();
    }

    public Collection<Cliente> buscarTodos() {
        return clienteRepository.findAll();

    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }

}
