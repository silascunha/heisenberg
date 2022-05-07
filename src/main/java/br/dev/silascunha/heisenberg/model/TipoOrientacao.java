package br.dev.silascunha.heisenberg.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TIPO_ORIENTACAO")
public class TipoOrientacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_orientacao")
    private Integer id;
    @Column(name = "nome_tipo_orientacao")
    private String nome;

    @OneToMany(mappedBy = "tipo")
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Orientacao> orientacoes;
}
