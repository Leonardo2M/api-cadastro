package br.com.test.api.domain.repository.usuario;

import br.com.test.api.domain.model.usuario.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Long> {
}
