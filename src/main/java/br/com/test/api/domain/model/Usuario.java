package br.com.test.api.domain.model;

import br.com.test.api.dto.alterar.DadosAtualizacaoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @OneToOne
    @JoinColumn(name = "id_pessoa_funcao")
    private PessoaFuncao pessoaFuncao;
    private String emailUsuario;
    private String loginUsuario;
    private String senhaUsuario;

    @ManyToOne
    @JoinColumn(name = "id_papel")
    private Papel papel;
    private Boolean statusUsuario;
    private String criadoPor;
    private LocalDate criadoData;
    private String modificadoPor;
    private LocalDate modificadoData;

    public Usuario(String loginUsuario, String emailUsuario, PessoaFuncao pessoaFuncao, Papel papel) {
        this.pessoaFuncao = pessoaFuncao;
        this.emailUsuario = emailUsuario;
        this.loginUsuario = loginUsuario;
        this.papel = papel;
        this.statusUsuario = true;
    }

    public void atualizar(DadosAtualizacaoUsuario dados,PessoaFuncao pessoaFuncao, Papel papel) {
        if(dados.getPessoaFuncao() != null) {
            this.pessoaFuncao.atualizar(pessoaFuncao);
        }
        if(dados.getEmailUsuario() != null) {
            this.emailUsuario = dados.getEmailUsuario();
        }

        if(dados.getLoginUsuario() != null) {
            this.loginUsuario = dados.getLoginUsuario();
        }

        if(dados.getSenhaUsuario() != null) {
            this.senhaUsuario = dados.getSenhaUsuario();
        }

        if(dados.getIdPapel() != null) {
            this.papel = papel;
        }
    }

    public void desativar() {
        this.statusUsuario = false;
    }
}
