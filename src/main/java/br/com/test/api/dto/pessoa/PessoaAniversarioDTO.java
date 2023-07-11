package br.com.test.api.dto.pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaAniversarioDTO {

    private String nomeCompleto;
    private LocalDate dataDeNascimento;

}
