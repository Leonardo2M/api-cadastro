package br.com.test.api.controller;

import br.com.test.api.domain.model.Usuario;
import br.com.test.api.domain.service.UsuarioService;
import br.com.test.api.dto.ListagemUsuario;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity cadastrarUsuario(@RequestBody Usuario usuario) {
        return service.cadastrarUsuario(usuario);
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

