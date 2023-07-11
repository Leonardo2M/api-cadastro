package br.com.test.api.domain.service.usuario;

import br.com.test.api.domain.model.usuario.Endereco;
import br.com.test.api.domain.repository.usuario.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Endereco endereco) {
        repository.save(endereco);
    }
}
