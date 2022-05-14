package br.dev.silascunha.heisenberg.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TIPO_ORIENTACAO", uniqueConstraints = @UniqueConstraint(name = "UK_NOME_TIPO_ORIENTACAO", columnNames = "nome_tipo_orientacao"))
public class TipoOrientacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_orientacao")
    private Integer id;
    @Column(name = "nome_tipo_orientacao", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "tipo")
    @JsonIgnore
    private List<Orientacao> orientacoes;
}
