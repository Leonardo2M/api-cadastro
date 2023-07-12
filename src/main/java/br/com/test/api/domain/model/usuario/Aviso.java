package br.com.test.api.domain.model.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_avisos")
@AllArgsConstructor
@NoArgsConstructor
public class Aviso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAviso;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    private String tituloAviso;
    private Boolean statusAviso;
    private String criadoPor;
    private LocalDate criadoData;
    private String modificadoPor;
    private LocalDate modificadoData;

}
