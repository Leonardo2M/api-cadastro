package br.com.test.api.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;
    private String nomeCompleto;
    private LocalDate dataDeNascimento;
    private String cpf;
    private String telefone;
    private Boolean possuiDeficiencia;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    private Boolean statusPessoa;
    private String criadoPor;
    private LocalDate criadoData;
    private String modificadoPor;
    private LocalDate modificadoData;

}
