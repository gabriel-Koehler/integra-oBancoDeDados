package net.weg.api.repository;

import net.weg.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Integer> {

}
