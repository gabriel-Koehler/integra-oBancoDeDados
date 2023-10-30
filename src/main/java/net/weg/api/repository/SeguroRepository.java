package net.weg.api.repository;

import net.weg.api.model.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroRepository extends JpaRepository<Seguro,Integer> {
}
