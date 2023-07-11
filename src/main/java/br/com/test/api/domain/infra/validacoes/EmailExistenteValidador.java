package br.com.test.api.domain.infra.validacoes;

import br.com.test.api.domain.infra.exception.DadosCadastradosException;
import br.com.test.api.domain.repository.UsuarioRepository;
import br.com.test.api.dto.cadastro.DadosCadastroUsuario;
import org.springframework.stereotype.Component;

@Component
public class EmailExistenteValidador implements Validacoes {

    private final UsuarioRepository repository;

    public EmailExistenteValidador(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validarCadastro(DadosCadastroUsuario dados) {
        var email = dados.getEmailUsuario();

        if(repository.existsByEmailUsuario(email)) {
            throw new DadosCadastradosException("Email: " + email + " já registrado.");
        }
    }
}
