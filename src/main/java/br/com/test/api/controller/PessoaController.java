package br.com.test.api.controller;

import br.com.test.api.domain.service.email.EmailService;
import br.com.test.api.domain.service.usuario.PessoaService;
import br.com.test.api.dto.pessoa.PessoaAniversarioDTO;
import br.com.test.api.dto.email.MessagemParabens;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearer-key")
public class PessoaController {

    private final PessoaService pessoaService;
    private final EmailService emailService;

    public PessoaController(PessoaService pessoaService, EmailService emailService) {
        this.pessoaService = pessoaService;
        this.emailService = emailService;
    }

    @GetMapping("/aniversarios")
    public ResponseEntity<List<PessoaAniversarioDTO>> consultarAniversarioDaSeamana() {
        return pessoaService.consultarAniversariantes();
    }

    @PostMapping("/aniversarios")
    public ResponseEntity<List<PessoaAniversarioDTO>> enviarParabens(@Valid @RequestBody MessagemParabens messagemParabens) {
        return emailService.enviarParabens(messagemParabens);
    }

}
