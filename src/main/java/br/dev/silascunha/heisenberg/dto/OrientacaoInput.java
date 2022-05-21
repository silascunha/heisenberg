package br.dev.silascunha.heisenberg.dto;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class OrientacaoInput implements Serializable {

    @EqualsAndHashCode.Include()
    private Integer idTipo;
    @EqualsAndHashCode.Include()
    private Integer idExame;
    private String descricao;

}
