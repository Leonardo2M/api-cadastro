package br.com.test.api.domain.model.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DadosLogin {

    @NotBlank
    private String login;

    @NotNull
    private String senha;

}
