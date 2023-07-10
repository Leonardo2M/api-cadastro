package br.com.test.api.controller;

import br.com.test.api.domain.model.Usuario;
import br.com.test.api.domain.service.UsuarioService;
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
    public ResponseEntity<List<Usuario>> mostrarUsarios() {
        return service.consultarUsarios();
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUusario(@RequestBody Usuario usuario) {
        System.out.println("entrou");
        return service.cadastrarUsuario(usuario);
    }
}
