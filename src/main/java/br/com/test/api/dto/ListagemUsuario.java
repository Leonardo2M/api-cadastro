package br.com.test.api.dto;

import br.com.test.api.dto.usuario.PapelDTO;
import br.com.test.api.dto.usuario.PessoaFuncaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListagemUsuario {

    private PessoaFuncaoDTO pessoaFuncao;
    private String emailUsuario;
    private PapelDTO papel;

}
