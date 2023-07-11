package br.com.test.api.domain.infra.validacoes;

import br.com.test.api.domain.infra.exception.DadosCadastradosException;
import br.com.test.api.domain.repository.usuario.UsuarioRepository;
import br.com.test.api.dto.usuario.cadastro.DadosCadastroUsuario;
import org.springframework.stereotype.Component;

@Component
public class EmailExistenteValidador implements Validacoes{

    private final UsuarioRepository repository;

    public EmailExistenteValidador(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validarCadastro(DadosCadastroUsuario dados) {
        var email = dados.getEmailUsuario();

        if(repository.existsByPessoaFuncaoPessoaCpf(email)) {
            throw new DadosCadastradosException("EMAIL: " + email + " já foi cadastrado.");
        }
    }

}
