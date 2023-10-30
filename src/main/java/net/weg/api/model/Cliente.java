package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente extends Usuario{

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Carro> carros;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Endereco> endereco;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;

}
