package br.com.test.api.domain.repository;

import br.com.test.api.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByStatusUsuarioIsTrue();

    boolean existsByPessoaFuncaoPessoaCpf(String cpf);

    boolean existsByLoginUsuario(String login);

    boolean existsByEmailUsuario(String email);

}
