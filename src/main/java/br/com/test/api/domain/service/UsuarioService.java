package br.com.test.api.domain.service;

import br.com.test.api.domain.exception.EntidadeNaoEncontradaException;
import br.com.test.api.domain.exception.UsuarioDesativadoException;
import br.com.test.api.domain.model.*;
import br.com.test.api.domain.repository.*;
import br.com.test.api.dto.cadastro.DadosCadastroUsuario;
import br.com.test.api.dto.DadosDetalhadosUsuario;
import br.com.test.api.dto.listagem.ListagemUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final AreaAtuacaoRepository areaAtuacaoRepository;
    private final FuncaoRepository funcaoRepository;
    private final NucleoRepository nucleoRepository;
    private final PapelRepository papelRepository;
    private final ModelMapper modelMapper;

    private final PessoaFuncaoService pessoaFuncaoService;

    public UsuarioService(UsuarioRepository repository, AreaAtuacaoRepository areaAtuacaoRepository, FuncaoRepository funcaoRepository, NucleoRepository nucleoRepository, PapelRepository papelRepository, ModelMapper modelMapper, PessoaFuncaoService pessoaFuncaoService) {
        this.repository = repository;
        this.areaAtuacaoRepository = areaAtuacaoRepository;
        this.funcaoRepository = funcaoRepository;
        this.nucleoRepository = nucleoRepository;
        this.papelRepository = papelRepository;
        this.modelMapper = modelMapper;
        this.pessoaFuncaoService = pessoaFuncaoService;
    }

    public ResponseEntity<List<ListagemUsuario>> consultarUsarios() {
        var usuarios = repository.findAllByStatusUsuarioIsTrue().stream().map(u -> modelMapper.map(u, ListagemUsuario.class)).toList();

        return ResponseEntity.ok(usuarios);
    }

    public ResponseEntity<DadosDetalhadosUsuario> cadastrarUsuario(DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder) {
        AreaAtuacao areaAtuacao = areaAtuacaoRepository.findById(dados.getPessoaFuncao().getIdAreaAtuacao()).orElseThrow(() -> new EntidadeNaoEncontradaException("Não existe área de atuação com esse id"));
        Funcao funcao = funcaoRepository.findById(dados.getPessoaFuncao().getIdFuncao()).orElseThrow(() -> new EntidadeNaoEncontradaException("Não existe função com esse id"));
        Nucleo nucleo = nucleoRepository.findById(dados.getPessoaFuncao().getIdNucleo()).orElseThrow(() -> new EntidadeNaoEncontradaException("Não existe núcleo com esse id"));
        Papel papel = papelRepository.findById(dados.getIdPapel()).orElseThrow(() -> new EntidadeNaoEncontradaException("Não existe papel com esse id"));

        PessoaFuncao pessoaFuncao = new PessoaFuncao(dados.getPessoaFuncao().getPessoa(), dados.getPessoaFuncao().getOabPessoaFuncao(), dados.getPessoaFuncao().getMatriculaPessoaFuncao(),
                areaAtuacao, funcao, nucleo);

        pessoaFuncaoService.salvar(pessoaFuncao);

        Usuario usuario = new Usuario(dados.getLoginUsuario(), dados.getEmailUsuario(), dados.getSenhaUsuario(), pessoaFuncao, papel);

        repository.save(usuario);

        var uri = uriComponentsBuilder.path("usuarios/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();

        return ResponseEntity.created(uri).body(modelMapper.map(usuario, DadosDetalhadosUsuario.class));
    }

    public ResponseEntity<DadosDetalhadosUsuario> alterarUsuario(Long id, Usuario dados) {
        var usuario = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Não foi encontrado usuário com id = " + id));
        usuario.atualizar(dados);
        repository.save(usuario);

        return ResponseEntity.ok().body(modelMapper.map(usuario, DadosDetalhadosUsuario.class));
    }

    public ResponseEntity<?> deletar(Long id) {
        var usuario = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Não foi encontrado usuário com id = " + id));

        if(!usuario.getStatusUsuario()) {
            throw new UsuarioDesativadoException("Usuário já excluído do sistema.");
        }

        usuario.desativar();

        return ResponseEntity.noContent().build();
    }
}
