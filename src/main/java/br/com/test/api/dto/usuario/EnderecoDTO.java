package br.com.test.api.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoDTO {

    private String ruaEndereco;
    private int numeroEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;
    private String cepEndereco;
    private String estadoEndereco;
    private String paisEndereco;
    private String complementoEndereco;

}
