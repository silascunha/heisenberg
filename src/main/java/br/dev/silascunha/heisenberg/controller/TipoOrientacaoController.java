package br.dev.silascunha.heisenberg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.dev.silascunha.heisenberg.model.TipoOrientacao;
import br.dev.silascunha.heisenberg.service.TipoOrientacaoService;

@RestController
@RequestMapping("/tiposOrientacao")
public class TipoOrientacaoController {
	
	@Autowired
	private TipoOrientacaoService tipoOrientacaoService;


	@GetMapping
	public ResponseEntity<List<TipoOrientacao>> listarTiposOrientacao() {
		List<TipoOrientacao> tiposOrientacao = tipoOrientacaoService.listarTiposOrientacao();

		return ResponseEntity.ok().body(tiposOrientacao);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoOrientacao> getTipoOrientacaoById(Integer id) {
		TipoOrientacao tipoOrientacao = tipoOrientacaoService.getTipoOrientacaoById(id);

		return ResponseEntity.ok().body(tipoOrientacao);
	}

	@PostMapping
	public ResponseEntity<TipoOrientacao> salvarTipoOrientacao(@RequestBody TipoOrientacao tipoOrientacao) {
		tipoOrientacao = tipoOrientacaoService.salvarTipoOrientacao(tipoOrientacao);

		return ResponseEntity.ok().body(tipoOrientacao);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoOrientacao> atualizarTipoOrientacao(@RequestBody TipoOrientacao tipoOrientacao, @PathVariable Integer id) {
		tipoOrientacao = tipoOrientacaoService.atualizarTipoOrientacao(tipoOrientacao,id);

		return ResponseEntity.ok().body(tipoOrientacao);
	}
}
