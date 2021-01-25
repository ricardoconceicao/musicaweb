package com.entrevista.musicaweb.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.entrevista.musicaweb.entidades.Artista;
import com.entrevista.musicaweb.entidades.ArtistaDetalhe;
import com.entrevista.musicaweb.entidades.ArtistaInterface;
import com.entrevista.musicaweb.entidades.repositorios.ArtistaRepository;
import com.entrevista.musicaweb.exception.NegocioException;

@Component
public class ArtistaServico {

	@Autowired
	private ArtistaRepository artistaRepository;
	
	public List<ArtistaInterface> listar(int page, int size){
	return	  artistaRepository.listar(PageRequest.of(page, size));
	}


	public void salvar(Artista artista) {
		artistaRepository.save(artista);
	}


	public void remover(Long cod) {
		artistaRepository.deleteById(cod);
	}


	public Artista buscar(String nome) {
		Artista art = new Artista();
		art.setNome(nome);
		Example<Artista> example = Example.of(art);
		return artistaRepository.findOne(example).get();
	}


	public ArtistaDetalhe detalhar(Long cod) {
		return artistaRepository.detalhar(cod);
	}
	
	public Artista buscaPorId(Long cod) throws NegocioException {
		
		return	artistaRepository.findById(cod).orElseThrow(() -> new NegocioException("O Artista não foi encontrado"));
	}
	
}
