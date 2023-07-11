package br.com.test.api.dto.usuario.alterar;

import br.com.test.api.dto.usuario.cadastro.PessoaFuncaoCadastro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DadosAtualizacaoUsuario {

    private PessoaFuncaoCadastro pessoaFuncao;
    private String emailUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private Long idPapel;
    
}
