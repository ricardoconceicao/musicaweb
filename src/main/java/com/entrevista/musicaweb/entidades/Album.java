package com.entrevista.musicaweb.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_album",schema = "entrevista")
public class Album implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1899088580935114497L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	
	private String nome;
	
	@Column(name = "dt_criacao")
	private Date dtCriacao;
	
	//@OneToMany(mappedBy = "album")
	@Transient
	private List<Musica> musicas;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_artista")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Artista artista;

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

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	

	
	
}
