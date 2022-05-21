package br.dev.silascunha.heisenberg.controller;

import java.util.List;

import br.dev.silascunha.heisenberg.dto.OrientacaoOutput;
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
    public ResponseEntity<List<OrientacaoOutput>> getAllOrientacoes() {
        List<OrientacaoOutput> orientacoesDto = orientacaoService.getAllOrientacoes();

        return ResponseEntity.ok(orientacoesDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrientacaoOutput> getOrientacaoById(@PathVariable Integer id) {
        OrientacaoOutput orientacaoInput = orientacaoService.getOrientacaoById(id);

        return ResponseEntity.ok(orientacaoInput);
    }
    
    @PostMapping
    public ResponseEntity<Orientacao> saveOrientacao(@RequestBody OrientacaoInput orientacaoInput) {
        Orientacao orientacao = orientacaoService.saveOrientacao(orientacaoInput);

        return ResponseEntity.ok(orientacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orientacao> updateOrientacao(@RequestBody OrientacaoInput orientacaoInput, @PathVariable Integer id) {
        Orientacao orientacao = orientacaoService.updateOrientacao(orientacaoInput, id);

        return ResponseEntity.ok().body(orientacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrientacao(@PathVariable Integer id) {
        orientacaoService.deleteOrientacao(id);

        return ResponseEntity.noContent().build();
    }
}
