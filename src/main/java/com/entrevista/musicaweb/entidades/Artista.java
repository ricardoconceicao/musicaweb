package com.entrevista.musicaweb.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_artista",schema = "entrevista")
public class Artista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8238455901211837337L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	
	private String nome;
	
	private String foto;
	
	@Column(name = "rede_social")
	private String redeSocial;
	
	private String biografia;
	
	//@OneToMany(mappedBy = "artista")
	@Transient
	private List<Album> albuns;

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

	public List<Album> getAlbuns() {
		return albuns;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

	
	
	
	
	
}
