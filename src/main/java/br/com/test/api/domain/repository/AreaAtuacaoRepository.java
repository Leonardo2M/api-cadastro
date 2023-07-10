package br.com.test.api.domain.repository;

import br.com.test.api.domain.model.AreaAtuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaAtuacaoRepository extends JpaRepository<AreaAtuacao, Long> {
}
