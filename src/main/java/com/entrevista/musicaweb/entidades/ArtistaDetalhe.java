package com.entrevista.musicaweb.entidades;

import java.util.List;

public interface ArtistaDetalhe {

	//foto, nome, link instagram, link facebook, link wikipedia, link twitter, Bio, lista de álbuns
	String getFoto();
	String getNome();
	String getRedeSocial();
	String getBiografia();
	List<Album> getAlguns();
}
