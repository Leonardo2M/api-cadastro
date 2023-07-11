package br.com.test.api.dto.usuario.listagem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaFuncaoDTO {

    private PessoaDTO pessoa;
    private String matriculaPessoaFuncao;
    private String oabPessoaFuncao;
    private NucleoDTO nucleo;
    private AreaAtuacaoDTO areaAtuacao;
    private FuncaoDTO funcao;

}
