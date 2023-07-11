package br.com.test.api.domain.infra.validacoes;

import br.com.test.api.dto.cadastro.DadosCadastroUsuario;
import org.springframework.stereotype.Component;

@Component
public interface Validacoes {

    void validarCadastro(DadosCadastroUsuario dados);

}
