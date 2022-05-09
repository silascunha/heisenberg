package br.dev.silascunha.heisenberg.dto;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrientacaoInput implements Serializable {

    private Integer idTipo;
    private Integer idExame;
    private String descricao;

}
