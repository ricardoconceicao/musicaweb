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

import com.entrevista.musicaweb.entidades.Artista;
import com.entrevista.musicaweb.entidades.ArtistaDetalhe;
import com.entrevista.musicaweb.entidades.ArtistaInterface;
import com.entrevista.musicaweb.servico.ArtistaServico;

@RestController
@RequestMapping("/musicaweb/artista")
public class ArtistaController {

	@Autowired
	private ArtistaServico artistaServico;
	
	@PostMapping({"/salvar"})
	public ResponseEntity<String> salvar(@RequestBody Artista artista){
		artistaServico.salvar(artista);
		return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
	}
	
	@GetMapping("/listar")
	public List<ArtistaInterface> listar(@RequestParam(name = "page", defaultValue = "0") String page,
			@RequestParam(name = "size", defaultValue = "5") String size){
	return	artistaServico.listar(Integer.parseInt(page), Integer.parseInt(size));
	}
	
	
	@GetMapping("/remover")
	public ResponseEntity<String> remover(@RequestParam(name = "cod") Long cod){
		 artistaServico.remover(cod);
		 return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Artista> buscar(@RequestParam(name = "nome")String nome){
		return ResponseEntity.status(HttpStatus.OK).body(artistaServico.buscar(nome));
	}
	
	@GetMapping("/detalhar")
	public ResponseEntity<ArtistaDetalhe> detalhar(@RequestParam(name = "cod")Long cod){
		return ResponseEntity.status(HttpStatus.OK).body(artistaServico.detalhar(cod));
	}
}
