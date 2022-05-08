package br.dev.silascunha.heisenberg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.silascunha.heisenberg.dto.OrientacaoDTO;
import br.dev.silascunha.heisenberg.model.Orientacao;
import br.dev.silascunha.heisenberg.service.OrientacaoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/orientacoes")
public class OrientacaoController {
    
    @Autowired
    private OrientacaoService orientacaoService;


    @GetMapping
    public ResponseEntity<List<OrientacaoDTO>> getAllOrientacoes() {
        List<OrientacaoDTO> orientacoesDto = orientacaoService.getAllOrientacoes();

        return ResponseEntity.ok(orientacoesDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrientacaoDTO> getOrientacaoById(@PathVariable Integer id) {
        OrientacaoDTO orientacaoDto = orientacaoService.getOrientacaoById(id);

        return ResponseEntity.ok(orientacaoDto);
    }
    
    @PostMapping
    public ResponseEntity<Orientacao> saveOrientacao(@RequestBody OrientacaoDTO orientacaoDto) {
        System.out.println(orientacaoDto);
        Orientacao orientacao = orientacaoService.saveOrientacao(orientacaoDto);

        return ResponseEntity.ok(orientacao);
    }
}
