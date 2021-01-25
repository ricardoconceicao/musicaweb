package com.entrevista.musicaweb.entidades.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entrevista.musicaweb.entidades.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long>{

}
