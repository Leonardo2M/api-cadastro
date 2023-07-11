package br.com.test.api.domain.service.usuario;

import br.com.test.api.domain.model.usuario.Pessoa;
import br.com.test.api.domain.repository.usuario.PessoaRepository;
import br.com.test.api.dto.pessoa.PessoaAniversarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository repository;
    private final EnderecoService enderecoService;
    private final ModelMapper modelMapper;

    public PessoaService(PessoaRepository repository, EnderecoService enderecoService, ModelMapper modelMapper) {
        this.repository = repository;
        this.enderecoService = enderecoService;
        this.modelMapper = modelMapper;
    }

    public void salvar(Pessoa pessoa) {
        enderecoService.salvar(pessoa.getEndereco());
        repository.save(pessoa);
    }

    public ResponseEntity<List<PessoaAniversarioDTO>> consultarAniversariantes() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate domingoDaSemana = dataAtual.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate sabadoDaSemana = domingoDaSemana.plusDays(6);

        var aniversariantes = repository.encontrarAniversariantesDaSemanaOrdenado(domingoDaSemana, sabadoDaSemana).stream().map(a -> modelMapper.map(a, PessoaAniversarioDTO.class)).toList();

        return ResponseEntity.ok().body(aniversariantes);
    }

}
