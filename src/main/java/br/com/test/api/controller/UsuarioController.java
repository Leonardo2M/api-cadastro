package br.com.test.api.controller;

import br.com.test.api.domain.model.Usuario;
import br.com.test.api.domain.service.UsuarioService;
import br.com.test.api.dto.cadastro.DadosCadastroUsuario;
import br.com.test.api.dto.listagem.ListagemUsuario;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ListagemUsuario>> mostrarUsarios() {
        return service.consultarUsarios();
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder) {
        return service.cadastrarUsuario(dados, uriComponentsBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity alterarUsuario(@PathVariable Long id, @RequestBody Usuario dados) {
        return service.alterarUsuario(id, dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarUsuario(@PathVariable Long id) {
        return service.deletar(id);
    }
}

