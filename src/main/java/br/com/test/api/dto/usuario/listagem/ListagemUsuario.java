package br.com.test.api.dto.usuario.listagem;

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
