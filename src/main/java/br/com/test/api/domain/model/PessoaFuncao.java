package br.com.test.api.domain.model;

import br.com.test.api.dto.listagem.PessoaDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_pessoa_funcao")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaFuncao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoaFuncao;

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    private String matriculaPessoaFuncao;
    private String oabPessoaFuncao;

    @ManyToOne
    @JoinColumn(name = "id_nucleo")
    @JsonBackReference("nucleoReference")
    private Nucleo nucleo;

    @ManyToOne
    @JoinColumn(name= "id_area_atuacao")
    @JsonBackReference("areaAtuacaoReference")
    private AreaAtuacao areaAtuacao;

    @ManyToOne
    @JoinColumn(name = "id_funcao")
    private Funcao funcao;

    private Boolean statusPessoaFuncao;
    private String criadoPor;
    private LocalDate criadoData;
    private String modificadoPor;
    private LocalDate modificadoData;

    public PessoaFuncao(PessoaDTO pessoa, String oabPessoaFuncao, String matriculaPessoaFuncao, AreaAtuacao areaAtuacao, Funcao funcao, Nucleo nucleo) {
        this.pessoa = new Pessoa(pessoa);
        this.matriculaPessoaFuncao = matriculaPessoaFuncao;
        this.oabPessoaFuncao = oabPessoaFuncao;
        this.nucleo = nucleo;
        this.areaAtuacao = areaAtuacao;
        this.funcao = funcao;
        this.statusPessoaFuncao = true;
    }

    public void atualizar(PessoaFuncao pessoaFuncao) {
        if(pessoaFuncao.getPessoa() != null) {
            this.pessoa.atualizar(pessoaFuncao.getPessoa());
        }

        if(pessoaFuncao.getMatriculaPessoaFuncao() != null) {
            this.matriculaPessoaFuncao = pessoaFuncao.getMatriculaPessoaFuncao();
        }

        if(pessoaFuncao.getOabPessoaFuncao() != null) {
            this.oabPessoaFuncao = pessoaFuncao.getOabPessoaFuncao();
        }

        if (pessoaFuncao.getNucleo() != null) {
            this.nucleo = pessoaFuncao.getNucleo();
        }

        if (pessoaFuncao.getAreaAtuacao() != null) {
            this.areaAtuacao = pessoaFuncao.getAreaAtuacao();
        }

        if (pessoaFuncao.getFuncao() != null) {
            this.funcao = pessoaFuncao.getFuncao();
        }
    }
}
