package br.com.test.api.domain.service;

import br.com.test.api.domain.model.Endereco;
import br.com.test.api.domain.repository.EnderecoRepository;
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
