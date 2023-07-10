package br.com.test.api.dto.listagem;

import br.com.test.api.dto.listagem.PapelDTO;
import br.com.test.api.dto.listagem.PessoaFuncaoDTO;
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
