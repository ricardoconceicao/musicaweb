package com.entrevista.musicaweb.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControleExceptionHandler  {

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<ResultadoErro> erroNegocio(NegocioException ex, HttpServletRequest req){
		ResultadoErro erro = new ResultadoErro("Exceção de Negócio",ex.getMessage(),null, HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResultadoErro> erroServicoExterno(Exception ex, HttpServletRequest req){
		ResultadoErro erro = new ResultadoErro("Erro inesperado",ex.getMessage(),null,HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
