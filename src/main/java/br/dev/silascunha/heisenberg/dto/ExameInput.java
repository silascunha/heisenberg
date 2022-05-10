package br.dev.silascunha.heisenberg.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExameInput implements Serializable {

    private String nome;
    private String descricao;
    private List<SinonimoInput> sinonimos = new ArrayList<>();
    private List<OrientacaoInput> orientacoes = new ArrayList<>();

}
