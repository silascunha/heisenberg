package br.dev.silascunha.heisenberg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.dev.silascunha.heisenberg.dto.OrientacaoInput;
import br.dev.silascunha.heisenberg.model.Orientacao;
import br.dev.silascunha.heisenberg.service.OrientacaoService;

@RestController
@RequestMapping("/orientacoes")
@CrossOrigin
public class OrientacaoController {
    
    @Autowired
    private OrientacaoService orientacaoService;


    @GetMapping
    public ResponseEntity<List<OrientacaoInput>> getAllOrientacoes() {
        List<OrientacaoInput> orientacoesDto = orientacaoService.getAllOrientacoes();

        return ResponseEntity.ok(orientacoesDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrientacaoInput> getOrientacaoById(@PathVariable Integer id) {
        OrientacaoInput orientacaoInput = orientacaoService.getOrientacaoById(id);

        return ResponseEntity.ok(orientacaoInput);
    }
    
    @PostMapping
    public ResponseEntity<Orientacao> saveOrientacao(@RequestBody OrientacaoInput orientacaoInput) {
        Orientacao orientacao = orientacaoService.saveOrientacao(orientacaoInput);

        return ResponseEntity.ok(orientacao);
    }

}
