package com.entrevista.musicaweb.entidades.repositorios;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entrevista.musicaweb.entidades.Artista;
import com.entrevista.musicaweb.entidades.ArtistaDetalhe;
import com.entrevista.musicaweb.entidades.ArtistaInterface;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista,Long>{

	//@Query("select ar.foto, ar.nome, ar.redeSocial, ar.biografia, al  from Artista ar LEFT JOIN ar.albuns al where ar.cod = :cod ")
	@Query(value = "select ar.foto, ar.nome, ar.rede_social as redeSocial, ar.biografia from entrevista.tb_artista ar LEFT JOIN entrevista.tb_album al on ar.cod=al.id_artista where ar.cod = :cod", nativeQuery = true)
	ArtistaDetalhe detalhar(@Param("cod") Long cod);

	@Query(value = "select a.cod, a.nome from entrevista.tb_artista a order by a.nome asc",nativeQuery=true)
	List<ArtistaInterface> listar(Pageable pageable);

}
