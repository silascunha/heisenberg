package br.dev.silascunha.heisenberg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EXAME", uniqueConstraints = {@UniqueConstraint(name = "UK_NOME_EXAME", columnNames = "nome_exame")})
public class Exame implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exame")
    private Integer id;
    @Column(name = "nome_exame", length = 100, nullable = false)
    private String nome;
    @Column(name = "descricao_exame", length = 5000)
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_exame")
    private final List<Sinonimo> sinonimos = new ArrayList<>();

    @OneToMany(mappedBy = "exame")
    private List<Orientacao> orientacoes = new ArrayList<>();
}
