package com.entrevista.musicaweb.exception;


public class ResultadoErro {

	private String titulo;
	
	private String detalhe;
	
	private String tipo;

	private Integer status;
	

	public ResultadoErro(String titulo, String detalhe, String tipo, Integer status) {
		super();
		this.titulo = titulo;
		this.detalhe = detalhe;
		this.tipo = tipo;
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
