package com.entrevista.musicaweb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entrevista.musicaweb.dto.MusicaDto;
import com.entrevista.musicaweb.entidades.Musica;
import com.entrevista.musicaweb.entidades.MusicaDetalhada;
import com.entrevista.musicaweb.entidades.MusicaInterface;
import com.entrevista.musicaweb.exception.NegocioException;
import com.entrevista.musicaweb.servico.MusicaServico;

@RestController
@RequestMapping("/musicaweb/musica")
public class MusicaController {

	@Autowired
	private MusicaServico musicaServico;

	@PostMapping({ "/salvar" })
	public ResponseEntity<String> salvar(@RequestBody MusicaDto dto) throws NegocioException {
		musicaServico.salvar(dto);
		return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
	}

	@GetMapping("/listar")
	public List<MusicaInterface> listar(
			@RequestParam(name = "page", defaultValue = "0") String page,
			@RequestParam(name = "size", defaultValue = "5") String size) {
		return musicaServico.listar(Integer.parseInt(page), Integer.parseInt(size));
	}

	@GetMapping("/remover")
	public ResponseEntity<String> remover(@RequestParam(name = "cod") Long cod) {
		musicaServico.remover(cod);
		return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
	}

	@GetMapping("/buscar")
	public ResponseEntity<Musica> buscarPorNome(@RequestParam(name = "nome") String nome) {
		return ResponseEntity.status(HttpStatus.OK).body(musicaServico.buscar(nome));
	}

	@PostMapping("/buscar")
	public ResponseEntity<List<MusicaDto>> buscar(@RequestBody Musica musica) {
		
		return ResponseEntity.status(HttpStatus.OK).body( musicaServico.buscar(musica));
	}

	public ResponseEntity<MusicaDetalhada> detalhar(@RequestParam(name = "cod") Long cod) {
		return ResponseEntity.status(HttpStatus.OK).body(musicaServico.detalhar(cod));
	}
}
