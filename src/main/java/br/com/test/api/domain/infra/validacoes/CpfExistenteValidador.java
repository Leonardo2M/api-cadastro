package br.com.test.api.domain.infra.validacoes;

import br.com.test.api.domain.infra.exception.DadosCadastradosException;
import br.com.test.api.domain.repository.UsuarioRepository;
import br.com.test.api.dto.cadastro.DadosCadastroUsuario;
import org.springframework.stereotype.Component;

@Component
public class CpfExistenteValidador implements Validacoes{

    private final UsuarioRepository repository;

    public CpfExistenteValidador(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validarCadastro(DadosCadastroUsuario dados) {
        var cpf = dados.getPessoaFuncao().getPessoa().getCpf();

        if(repository.existsByPessoaFuncaoPessoaCpf(cpf)) {
            throw new DadosCadastradosException("CPF: " + cpf + " já foi cadastrado.");
        }
    }

}
