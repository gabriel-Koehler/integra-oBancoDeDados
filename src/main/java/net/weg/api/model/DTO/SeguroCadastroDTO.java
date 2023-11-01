package net.weg.api.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.model.Cliente;
import net.weg.api.model.Seguradora;

@Data
@AllArgsConstructor

public class SeguroCadastroDTO {

    private Double valor;
    private String descricao;
    private Double valorFranquia;
    private Seguradora seguradora;
    private Carro carro;
    private Cliente cliente;
}
