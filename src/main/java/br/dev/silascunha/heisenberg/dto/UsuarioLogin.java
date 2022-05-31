package br.dev.silascunha.heisenberg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioLogin implements Serializable {

    private String nomeUsuario;
    private String senha;

}
