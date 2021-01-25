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

import com.entrevista.musicaweb.dto.AlbumDto;
import com.entrevista.musicaweb.entidades.Album;
import com.entrevista.musicaweb.entidades.MusicaInterface;
import com.entrevista.musicaweb.exception.NegocioException;
import com.entrevista.musicaweb.servico.AlbumServico;

@RestController
@RequestMapping("/musicaweb/album")
public class AlbumController {

	@Autowired
	private AlbumServico albumServico;
	
	@PostMapping({"/salvar"})
	public ResponseEntity<String> salvar(@RequestBody AlbumDto dto) throws NegocioException{
		albumServico.salvar(dto);
		return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
	}
	
	
	@GetMapping("/listar")
	public List<Album> listar(){
	return	albumServico.listar();
	}
	
	@GetMapping("/listar-musicas")
	public ResponseEntity<List<MusicaInterface>> listarMusicasPorAlbum(@RequestParam(name ="cod") Long cod) {
	return 	ResponseEntity.status(HttpStatus.OK).body(albumServico.listarMusicas(cod));
	}
	
	@GetMapping("/remover")
	public ResponseEntity<String> remover(@RequestParam(name = "cod") Long cod){
		albumServico.remover(cod);
		return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Album> buscar(@RequestParam(name = "nome")String nome){
		return ResponseEntity.status(HttpStatus.OK).body(albumServico.buscar(nome));
	}
}
