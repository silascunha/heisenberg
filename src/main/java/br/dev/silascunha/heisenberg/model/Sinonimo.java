package br.dev.silascunha.heisenberg.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SINONIMO", uniqueConstraints = {@UniqueConstraint(name = "UK_SINONIMO", columnNames = {"nome_sinonimo", "id_exame"})})
public class Sinonimo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sinonimo")
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(name = "nome_sinonimo", nullable = false)
    private String nome;

}
