package br.com.test.api.domain.service;

import br.com.test.api.domain.model.Usuario;
import br.com.test.api.domain.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<Usuario>> consultarUsarios() {
        var usuarios = repository.findAll();

        return ResponseEntity.ok(usuarios);
    }

    public ResponseEntity cadastrarUsuario(Usuario usuario) {
        repository.save(usuario);

        return ResponseEntity.ok().build();
    }
}