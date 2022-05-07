package br.dev.silascunha.heisenberg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORIENTACAO")
public class Orientacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orientacao")
    private Integer id;
    @Column(name = "descricao_orientacao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_tipo_orientacao")
    private TipoOrientacao tipo;
    
    @ManyToOne
    @JoinColumn(name = "id_exame")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Exame exame;
    
}
