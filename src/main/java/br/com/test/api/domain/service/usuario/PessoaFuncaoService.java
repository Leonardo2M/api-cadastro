package br.com.test.api.domain.service.usuario;

import br.com.test.api.domain.model.usuario.PessoaFuncao;
import br.com.test.api.domain.repository.usuario.PessoaFuncaoRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaFuncaoService {

    private final PessoaFuncaoRepository repository;
    private final PessoaService pessoaService;

    public PessoaFuncaoService(PessoaFuncaoRepository repository, PessoaService pessoaService) {
        this.repository = repository;
        this.pessoaService = pessoaService;
    }

    public void salvar(PessoaFuncao pessoaFuncao) {
        pessoaService.salvar(pessoaFuncao.getPessoa());
        repository.save(pessoaFuncao);
    }

}
