package com.entrevista.musicaweb.servico;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.entrevista.musicaweb.dto.MusicaDto;
import com.entrevista.musicaweb.entidades.Album;
import com.entrevista.musicaweb.entidades.Musica;
import com.entrevista.musicaweb.entidades.MusicaDetalhada;
import com.entrevista.musicaweb.entidades.MusicaInterface;
import com.entrevista.musicaweb.entidades.repositorios.MusicaRepository;
import com.entrevista.musicaweb.exception.NegocioException;

@Component
public class MusicaServico {

	@Autowired
	private MusicaRepository musicaRepository;

	@Autowired
	private AlbumServico albumServico;

	public void salvar(MusicaDto dto) throws NegocioException {
		Album album = albumServico.buscarPorId(dto.getIdAlbum());
		Musica musica = null;

		if (dto.getCod() == null) {
			
			musica = new Musica();
			musica.setAlbum(album);
			musica.setFoto(dto.getFoto());
			musica.setGenero(dto.getGenero());
			musica.setNome(dto.getNome());
			musica.setTempoMusica(dto.getTempoMusica());
			musica.setVoto(dto.getVoto());
		} else {
			 musica = musicaRepository.getOne(dto.getCod());
			musica.setAlbum(album);
			musica.setFoto(dto.getFoto());
			musica.setGenero(dto.getGenero());
			musica.setNome(dto.getNome());
			musica.setTempoMusica(dto.getTempoMusica());
			musica.setVoto(dto.getVoto());
		}

		musicaRepository.save(musica);
	}

	public List<MusicaInterface> listar(int page, int size) {
		return musicaRepository.listar(PageRequest.of(page, size));
	}
	
	public List<MusicaInterface> listar(Long codAlbum,int page, int size) {
		return musicaRepository.listar(codAlbum,PageRequest.of(page, size));
	}

	public void remover(Long cod) {
		musicaRepository.deleteById(cod);
	}

	public Musica buscar(String nome) {
		Musica musica = new Musica();
		musica.setNome(nome);
		Example<Musica> example = Example.of(musica);
		return musicaRepository.findOne(example).get();
	}

	public List<MusicaDto> buscar(Musica musica) {
		Example<Musica> example = Example.of(musica);
		List<Musica> musicas = musicaRepository.findAll(example, Sort.by("nome"));
		
		return musicas.stream().map(m -> converterToDto(m)).collect(Collectors.toList());
		
	}

	private MusicaDto converterToDto(Musica m) {
		MusicaDto dto = new MusicaDto();
		
		dto.setNome(m.getNome());
		dto.setTempoMusica(m.getTempoMusica());
		return dto;
	}

	public MusicaDetalhada detalhar(Long cod) {
		return musicaRepository.detalharMusica(cod);
	}

}
