package br.com.test.api.domain.repository.usuario;

import br.com.test.api.domain.model.PessoaFuncao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFuncaoRepository extends JpaRepository<PessoaFuncao, Long> {
}
