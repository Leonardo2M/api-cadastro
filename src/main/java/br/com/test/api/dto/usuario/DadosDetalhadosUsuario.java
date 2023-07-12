package br.com.test.api.dto.usuario;

import br.com.test.api.dto.usuario.listagem.PapelDTO;
import br.com.test.api.dto.usuario.listagem.PessoaFuncaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DadosDetalhadosUsuario {

    private Long idUsuario;
    private PessoaFuncaoDTO pessoaFuncao;
    private String emailUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private PapelDTO papel;
    private Boolean statusUsuario;

}
