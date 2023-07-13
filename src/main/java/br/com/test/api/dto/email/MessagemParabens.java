package br.com.test.api.dto.email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessagemParabens {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotBlank
    @Email
    private String toEmail;

}
