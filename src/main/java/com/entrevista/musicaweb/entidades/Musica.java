package com.entrevista.musicaweb.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_musica")
public class Musica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5155424236381914456L;


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	
	private String nome;
	
	private String foto;
	
	@Column(name = "tempo_musica")
	private String tempoMusica;
	
	private Integer voto;
	
	private Integer genero;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_album")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Album album;

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


	public String getTempoMusica() {
		return tempoMusica;
	}

	public void setTempoMusica(String tempoMusica) {
		this.tempoMusica = tempoMusica;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
}
