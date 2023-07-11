package br.com.test.api.domain.infra.validacoes;

import br.com.test.api.domain.infra.exception.DadosCadastradosException;
import br.com.test.api.domain.repository.usuario.UsuarioRepository;
import br.com.test.api.dto.usuario.cadastro.DadosCadastroUsuario;
import org.springframework.stereotype.Component;

@Component
public class LoginExistenteValidador implements Validacoes{

    private final UsuarioRepository repository;

    public LoginExistenteValidador(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validarCadastro(DadosCadastroUsuario dados) {
        var login = dados.getLoginUsuario();

        if(repository.existsByLoginUsuario(login)) {
            throw new DadosCadastradosException("Login: " + login + " já registrado.");
        }
    }
}
