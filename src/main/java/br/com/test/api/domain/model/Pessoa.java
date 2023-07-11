package br.com.test.api.domain.model;

import br.com.test.api.dto.usuario.listagem.PessoaDTO;
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

    public Pessoa(PessoaDTO pessoa) {
        this.nomeCompleto = pessoa.getNomeCompleto();
        this.dataDeNascimento = pessoa.getDataDeNascimento();
        this.cpf = pessoa.getCpf();
        this.telefone = pessoa.getTelefone();
        this.possuiDeficiencia = pessoa.getPossuiDeficiencia();
        this.endereco = new Endereco(pessoa.getEndereco());
        this.statusPessoa = true;
    }

    public void atualizar(Pessoa pessoa) {
        if (pessoa.getNomeCompleto() != null) {
            this.nomeCompleto = pessoa.getNomeCompleto();
        }

        if (pessoa.getDataDeNascimento() != null) {
            this.dataDeNascimento = pessoa.getDataDeNascimento();
        }

        if (pessoa.getCpf() != null) {
            this.cpf = pessoa.getCpf();
        }

        if (pessoa.getTelefone() != null) {
            this.telefone = pessoa.getTelefone();
        }

        if (pessoa.getPossuiDeficiencia() != null) {
            this.possuiDeficiencia = pessoa.getPossuiDeficiencia();
        }

        if(pessoa.getEndereco() != null) {
            this.endereco.atualizar(pessoa.getEndereco());
        }
    }

    public void desativar() {
        this.statusPessoa = false;
    }
}
