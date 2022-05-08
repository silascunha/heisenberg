package br.dev.silascunha.heisenberg.dto;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrientacaoInput implements Serializable {

    private Integer id;
    private Integer idTipo;
    private String nomeTipo;
    private Integer idExame;
    private String descricao;

    
}
