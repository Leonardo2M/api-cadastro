package br.com.test.api.domain.model.usuario;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_area_atuacao")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AreaAtuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAreaAtuacao;
    private String descricaoAreaAtuacao;
    private Boolean statusAreaAtuacao;
    private String criadoPor;
    private LocalDate criadoData;
    private String modificadoPor;
    private LocalDate modificadoData;

    @OneToMany(mappedBy = "areaAtuacao")
    @JsonManagedReference("areaAtuacaoReference")
    private List<PessoaFuncao> pessoas = new ArrayList<>();

}
