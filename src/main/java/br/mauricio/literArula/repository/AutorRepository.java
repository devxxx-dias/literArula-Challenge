package br.mauricio.literArula.repository;

import br.mauricio.literArula.model.Autor;
import br.mauricio.literArula.model.Idiomas;
import br.mauricio.literArula.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNomeContainingIgnoreCase(String nomeAutor);

    @Query("SELECT l FROM Livros l")
    List<Livros> listarLivroRegistrados();

    @Query("SELECT a FROM Autor a")
    List<Autor> listarAutoresRegitrados();

    @Query("SELECT a FROM Autor a WHERE :ano BETWEEN a.anoDeNascimento AND a.anoDeFalecimento")
    List<Autor> listarAutoresVivosPeloAno(int ano);

    @Query("select l from Livros l where l.idiomas = :idioma")
    List<Livros> listarLivrosPorIdioma(Idiomas idioma);
}
