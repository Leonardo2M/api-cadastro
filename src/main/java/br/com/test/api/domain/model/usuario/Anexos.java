package br.com.test.api.domain.model.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_anexos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Anexos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnexos;
    private String tituloAnexo;
    private String nomeAnexo;
    private String pastaAnexo;

    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    private Boolean statusAnexo;
    private String criadoPor;
    private LocalDate criadoData;
    private String modificadoPor;
    private LocalDate modificadoData;
}
