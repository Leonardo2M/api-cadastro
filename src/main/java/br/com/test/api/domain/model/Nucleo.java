package br.com.test.api.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_nucleos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Nucleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNucleo;
    private String descricaoNucleo;
    private Boolean statusNucleo;
    private String criadoPor;
    private LocalDate criadoData;
    private String modificadoPor;
    private LocalDate modificadoData;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "nucleo")
    @JsonManagedReference("nucleoReference")
    private List<PessoaFuncao> pessoas = new ArrayList<>();
}
