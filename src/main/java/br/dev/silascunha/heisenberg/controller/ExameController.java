package br.dev.silascunha.heisenberg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.silascunha.heisenberg.model.Exame;
import br.dev.silascunha.heisenberg.service.ExameService;

@RestController
@RequestMapping("/exames")
@CrossOrigin
public class ExameController {
    
    @Autowired
    private ExameService exameService;


    @GetMapping
    public ResponseEntity<List<Exame>> getAllExames() {
        List<Exame> exames = exameService.getAllExames();

        return ResponseEntity.ok(exames);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exame> getExameById(Integer id) {
        Exame exame = exameService.getExameById(id);

        return ResponseEntity.ok(exame);
    }

    @PostMapping
    public ResponseEntity<Exame> saveExame(Exame exame) {
        Exame exameSaved = exameService.saveExame(exame);

        return ResponseEntity.ok(exameSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exame> updateExame(Exame exame, Integer id) {
        Exame exameSaved = exameService.updateExame(exame, id);

        return ResponseEntity.ok(exameSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExame(Integer id) {
        exameService.deleteExame(id);

        return ResponseEntity.ok().build();
    }

}
