package br.com.test.api.domain.repository;

import br.com.test.api.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //boolean existsByPessoaCpf(String cpf);

}
