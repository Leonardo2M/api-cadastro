package br.com.test.api.domain.model;

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

    @OneToOne
    @JoinColumn(name = "id_papel")
    private Papel papel;
    private Boolean statusUsuario;
    private String criadoPor;
    private LocalDate criadoData;
    private String modificadoPor;
    private LocalDate modificadoData;

    public void atualizar(Usuario dados) {
        this.pessoaFuncao.getPessoa().setNomeCompleto(dados.getPessoaFuncao().getPessoa().getNomeCompleto());
    }
}
