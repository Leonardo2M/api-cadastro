package br.com.test.api.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToOne
    @JoinColumn(name = "id_funcao")
    private Funcao funcao;

    private Boolean statusPessoaFuncao;
    private String criadoPor;
    private LocalDate criadoData;
    private String modificadoPor;
    private LocalDate modificadoData;
}