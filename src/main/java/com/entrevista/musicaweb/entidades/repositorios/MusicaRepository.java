package com.entrevista.musicaweb.entidades.repositorios;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entrevista.musicaweb.entidades.Musica;
import com.entrevista.musicaweb.entidades.MusicaDetalhada;
import com.entrevista.musicaweb.entidades.MusicaInterface;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long>{
	
	@Query("SELECT "
			+ "m.foto, "
			+ "m.nome, "
			+ "m.tempoMusica, "
			+ "al.nome as album, "
			+ "ar.nome as artista, "
			+ "al.dtCriacao as dtLancamento "
			+ " FROM Musica m INNER JOIN m.album al INNER JOIN al.artista ar WHERE m.cod = :cod ")
	MusicaDetalhada detalharMusica(@Param("cod")Long cod);

	@Query(value ="select m.cod, m.nome, m.tempo_musica tempoMusica, m.voto from entrevista.tb_musica m order by m.voto desc",nativeQuery = true)
	List<MusicaInterface> listar(Pageable pageable);

	@Query(value ="select m.cod, m.nome, m.tempo_musica tempoMusica, m.voto from entrevista.tb_musica m INNER JOIN entrevista.tb_album a ON m.id_album = a.cod WHERE a.cod = :idAlbum order by m.voto desc",nativeQuery = true)
	List<MusicaInterface> listar(@Param("idAlbum")Long codAlbum, Pageable of);

}
