package com.entrevista.musicaweb.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.entrevista.musicaweb.dto.AlbumDto;
import com.entrevista.musicaweb.entidades.Album;
import com.entrevista.musicaweb.entidades.Artista;
import com.entrevista.musicaweb.entidades.MusicaInterface;
import com.entrevista.musicaweb.entidades.repositorios.AlbumRepository;
import com.entrevista.musicaweb.exception.NegocioException;

@Component
public class AlbumServico {

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private ArtistaServico artistaServico;
	
	@Autowired
	private MusicaServico musicaServico;

	public void salvar(AlbumDto dto) throws NegocioException {
		Artista artista = artistaServico.buscaPorId(dto.getIdArtista());
		Album album = null;
		
		if (dto.getCod() == null) {
			album = new Album();
			album.setCod(dto.getCod());
			album.setNome(dto.getNome());
			album.setDtCriacao(new Date());
			album.setArtista(artista);
		} else {
			album = albumRepository.findById(dto.getCod()).get();
			album.setNome(dto.getNome());
			album.setArtista(artista);
		}

		albumRepository.save(album);
	}

	public List<Album> listar() {
		return albumRepository.findAll(PageRequest.of(0, 5, Sort.by("nome"))).toList();
	}

	public void remover(Long cod) {
		albumRepository.deleteById(cod);
	}

	public Album buscar(String nome) {
		Album album = new Album();
		album.setNome(nome);
		Example<Album> example = Example.of(album);
		return albumRepository.findOne(example).get();
	}

	public Album buscarPorId(Long cod) throws NegocioException {
		return albumRepository.findById(cod).orElseThrow(() -> new NegocioException("A musica não foi encontrado"));
	}
	
	public List<MusicaInterface> listarMusicas(Long cod){
		return musicaServico.listar(cod, 0, 5);
	}

}
