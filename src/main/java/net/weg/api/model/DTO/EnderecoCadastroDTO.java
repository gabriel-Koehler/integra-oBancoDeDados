package net.weg.api.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class EnderecoCadastroDTO {
    private  String rua,bairo;
    private Integer numero;

}
