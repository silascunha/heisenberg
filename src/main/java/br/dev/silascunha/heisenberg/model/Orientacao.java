package br.dev.silascunha.heisenberg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORIENTACAO", uniqueConstraints = {@UniqueConstraint(name = "UK_ORIENTACAO", columnNames = {"id_tipo_orientacao", "id_exame"})})
public class Orientacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orientacao")
    private Integer id;
    @Column(name = "descricao_orientacao", length = 3000)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_tipo_orientacao", nullable = false)
    private TipoOrientacao tipo;
    
    @ManyToOne
    @JoinColumn(name = "id_exame", nullable = false)
    @JsonIgnore
    private Exame exame;
    
}
