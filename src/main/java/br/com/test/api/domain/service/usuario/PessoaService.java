package br.com.test.api.domain.service.usuario;

import br.com.test.api.domain.model.Pessoa;
import br.com.test.api.domain.repository.usuario.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final PessoaRepository repository;
    private final EnderecoService enderecoService;

    public PessoaService(PessoaRepository repository, EnderecoService enderecoService) {
        this.repository = repository;
        this.enderecoService = enderecoService;
    }

    public void salvar(Pessoa pessoa) {
        enderecoService.salvar(pessoa.getEndereco());
        repository.save(pessoa);
    }

}
