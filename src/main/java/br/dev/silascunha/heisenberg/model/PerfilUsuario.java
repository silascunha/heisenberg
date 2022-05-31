package br.dev.silascunha.heisenberg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERFIL_USUARIO", uniqueConstraints = {@UniqueConstraint(name = "UK_NOME_PERFIL", columnNames = "nome_perfil")})
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    @EqualsAndHashCode.Exclude
    private Integer id;
    @Column(name = "nome_perfil")
    private String nome;
}
