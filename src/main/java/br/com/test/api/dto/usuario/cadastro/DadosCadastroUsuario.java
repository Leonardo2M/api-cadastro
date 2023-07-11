package br.com.test.api.dto.usuario.cadastro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DadosCadastroUsuario {

    private PessoaFuncaoCadastro pessoaFuncao;
    private String loginUsuario;
    private Long idPapel;

}
