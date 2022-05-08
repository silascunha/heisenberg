package br.dev.silascunha.heisenberg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORIENTACAO")
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
