package br.com.test.api.dto.usuario.cadastro;

import br.com.test.api.dto.usuario.listagem.PessoaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaFuncaoCadastro {

    private PessoaDTO pessoa;
    private String matriculaPessoaFuncao;
    private String oabPessoaFuncao;
    private Long idNucleo;
    private Long idAreaAtuacao;
    private Long idFuncao;

}
