# musicaweb

-buscar música por nome ou genêro
POST: localhost:8080/musicaweb/musica/buscar
{
"genero" : "1",
"nome" :"musica 2"
}


-Listar músicas por álbum:
GET localhost:8080/musicaweb/album/listar-musicas?cod=1


-Listar Álbum:
GET: localhost:8080/musicaweb/album/listar


-Listar Música:
GET: localhost:8080/musicaweb/musica/listar


-Listar Artistas:
localhost:8080/musicaweb/artista/listar


-Salvar Música
POST: localhost:8080/musicaweb/musica/salvar
{
"nome" : "demo 2",
"idAlbum": 2,
"foto":"foto 2",
"genero":3,
"voto" : 6,
"tempoMusica":"4:50"
}


Salvar Album
POST: localhost:8080/musicaweb/album/salvar
{
"nome" : "Album 2",
"idArtista": 2
}


-Salvar Artista
POST localhost:8080/musicaweb/artista/salvar
{
"nome" : "Artista 1",
"foto":"foto 1",
"tempoMusica":"2:00",
"voto":2,
"genero": 1
}