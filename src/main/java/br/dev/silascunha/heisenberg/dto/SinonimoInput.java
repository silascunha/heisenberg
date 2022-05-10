package br.dev.silascunha.heisenberg.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class SinonimoInput implements Serializable {

    @EqualsAndHashCode.Include
    private String nome;

}
