package com.entrevista.musicaweb.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude (JsonInclude.Include.NON_NULL)
public class MusicaDto {

	private Long cod;
	
	private String nome;
	
	private String foto;
	
	private String tempoMusica;
	
	private Integer voto;
	
	private Integer genero;
	
	private Long idAlbum;

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTempoMusica() {
		return tempoMusica;
	}

	public void setTempoMusica(String tempoMusica) {
		this.tempoMusica = tempoMusica;
	}

	public Integer getVoto() {
		return voto;
	}

	public void setVoto(Integer voto) {
		this.voto = voto;
	}

	public Integer getGenero() {
		return genero;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	public Long getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Long idAlbum) {
		this.idAlbum = idAlbum;
	}
}
