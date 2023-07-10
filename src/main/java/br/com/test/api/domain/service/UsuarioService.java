package br.com.test.api.domain.service;

import br.com.test.api.domain.model.Usuario;
import br.com.test.api.domain.repository.UsuarioRepository;
import br.com.test.api.dto.ListagemUsuario;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<List<ListagemUsuario>> consultarUsarios() {
        var usuarios = repository.findAllByStatusUsuarioIsTrue().stream().map(u -> modelMapper.map(u, ListagemUsuario.class)).toList();

        return ResponseEntity.ok(usuarios);
    }

    public ResponseEntity cadastrarUsuario(Usuario usuario) {
        repository.save(usuario);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity alterarUsuario(Long id, Usuario dados) {
        var usuario = repository.findById(id).orElseThrow();
        usuario.atualizar(dados);
        repository.save(usuario);

        return ResponseEntity.ok().body(usuario);
    }

    public ResponseEntity deletar(Long id) {
        var usuario = repository.findById(id).orElseThrow();
        usuario.desativar();

        return ResponseEntity.noContent().build();
    }
}
