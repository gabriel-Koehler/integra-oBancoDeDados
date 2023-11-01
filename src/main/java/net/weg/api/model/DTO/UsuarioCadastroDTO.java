package net.weg.api.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class UsuarioCadastroDTO {

    private String usuario;
    private String senha;
    private  Integer idade;
    private Set<EnderecoCadastroDTO> listaEnderecos;

}
