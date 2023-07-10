package br.com.test.api.dto.cadastro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DadosCadastroUsuario {

    private PessoaFuncaoCadastro pessoaFuncao;
    private String emailUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private Long idPapel;

}
