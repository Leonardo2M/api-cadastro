package br.com.test.api.domain.model.usuario;


import br.com.test.api.dto.usuario.listagem.EnderecoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_enderecos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    private String ruaEndereco;
    private int numeroEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;
    private String cepEndereco;
    private String estadoEndereco;
    private String paisEndereco;
    private String complementoEndereco;
    private Boolean statusEndereco;
    private String criadoPor;
    private LocalDate criadoData;
    private String modificadoPor;
    private LocalDate modificadoData;


    public Endereco(EnderecoDTO endereco) {
        this.ruaEndereco = endereco.getRuaEndereco();
        this.numeroEndereco = endereco.getNumeroEndereco();
        this.bairroEndereco = endereco.getBairroEndereco();
        this.cidadeEndereco = endereco.getCidadeEndereco();
        this.cepEndereco = endereco.getCepEndereco();
        this.estadoEndereco = endereco.getEstadoEndereco();
        this.paisEndereco = endereco.getPaisEndereco();
        this.complementoEndereco = endereco.getComplementoEndereco();
        this.statusEndereco = true;
    }

    public void atualizar(Endereco endereco) {
        if (endereco.getRuaEndereco() != null) {
            this.ruaEndereco = endereco.getRuaEndereco();
        }

        if (endereco.getNumeroEndereco() != 0) {
            this.numeroEndereco = endereco.getNumeroEndereco();
        }

        if (endereco.getBairroEndereco() != null) {
            this.bairroEndereco = endereco.getBairroEndereco();
        }

        if (endereco.getCidadeEndereco() != null) {
            this.cidadeEndereco = endereco.getCidadeEndereco();
        }

        if (endereco.getCepEndereco() != null) {
            this.cepEndereco = endereco.getCepEndereco();
        }

        if (endereco.getEstadoEndereco() != null) {
            this.estadoEndereco = endereco.getEstadoEndereco();
        }

        if (endereco.getPaisEndereco() != null) {
            this.paisEndereco = endereco.getPaisEndereco();
        }

        if (endereco.getComplementoEndereco() != null) {
            this.complementoEndereco = endereco.getComplementoEndereco();
        }
    }

}
