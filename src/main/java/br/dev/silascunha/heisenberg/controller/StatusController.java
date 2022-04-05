package br.dev.silascunha.heisenberg.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@CrossOrigin
public class StatusController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> getStatus() {
        Map<String, Object> response = Map.of("status", "OK");

        return ResponseEntity.ok(response);
    }
}
