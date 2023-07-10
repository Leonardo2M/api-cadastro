package br.com.test.api.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO {

    private String nomeCompleto;
    private LocalDate dataDeNascimento;
    private String cpf;
    private String telefone;
    private Boolean possuiDeficiencia;
    private EnderecoDTO endereco;

}
