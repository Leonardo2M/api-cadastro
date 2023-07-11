package br.com.test.api.domain.repository.usuario;

import br.com.test.api.domain.model.usuario.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT p FROM Pessoa p WHERE DAY(p.dataDeNascimento) BETWEEN DAY(:domingoDaSemana) AND DAY(:sabadoDaSemana) " +
            "AND MONTH(p.dataDeNascimento) = MONTH(:domingoDaSemana) ORDER BY DAY(p.dataDeNascimento)")
    List<Pessoa> encontrarAniversariantesDaSemanaOrdenado(LocalDate domingoDaSemana, LocalDate sabadoDaSemana);
}
