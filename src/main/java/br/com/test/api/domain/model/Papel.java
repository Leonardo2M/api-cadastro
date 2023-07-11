package br.com.test.api.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_papel")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Papel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPapel;
    private String descricaoPapel;
    private Boolean statusPapel;
    private String criadoPor;
    private LocalDate criadoData;
    private String modificadoPor;
    private LocalDate modificadoData;

    @OneToMany
    private List<Usuario> usuarios = new ArrayList<>();

}
