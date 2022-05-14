package br.dev.silascunha.heisenberg.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrientacaoOutput implements Serializable {

    private Integer idOrientacao;
    private Integer idTipo;
    private String nomeTipo;
    private Integer idExame;
    private String descricao;

}
