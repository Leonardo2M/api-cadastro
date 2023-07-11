package br.com.test.api.controller;

import br.com.test.api.domain.service.usuario.PessoaService;
import br.com.test.api.dto.pessoa.PessoaAniversarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/aniversarios")
    public ResponseEntity<List<PessoaAniversarioDTO>> consultarAniversarioDaSeamana() {
        return pessoaService.consultarAniversariantes();
    }
}
