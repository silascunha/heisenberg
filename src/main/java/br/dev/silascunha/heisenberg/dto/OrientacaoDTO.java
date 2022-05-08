package br.dev.silascunha.heisenberg.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrientacaoDTO implements Serializable {
    
    private Integer id;
    private Integer idTipo;
    private String nomeTipo;
    private Integer idExame;
    private String descricao;

    
}
