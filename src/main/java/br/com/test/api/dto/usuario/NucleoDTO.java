package br.com.test.api.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NucleoDTO {

    private String descricaoNucleo;
    private EnderecoDTO endereco;

}
