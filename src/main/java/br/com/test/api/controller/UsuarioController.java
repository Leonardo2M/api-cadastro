package br.com.test.api.controller;

import br.com.test.api.domain.service.usuario.UsuarioService;
import br.com.test.api.dto.usuario.DadosDetalhadosUsuario;
import br.com.test.api.dto.usuario.alterar.DadosAtualizacaoUsuario;
import br.com.test.api.dto.usuario.cadastro.DadosCadastroUsuario;
import br.com.test.api.dto.usuario.listagem.ListagemUsuario;
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
    public ResponseEntity<DadosDetalhadosUsuario> cadastrarUsuario(@RequestBody DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder) {
        return service.cadastrarUsuario(dados, uriComponentsBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhadosUsuario> alterarUsuario(@PathVariable Long id, @RequestBody DadosAtualizacaoUsuario dados) {
        return service.alterarUsuario(id, dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        return service.deletar(id);
    }
}

