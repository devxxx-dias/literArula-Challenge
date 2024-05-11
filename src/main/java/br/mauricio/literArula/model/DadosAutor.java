package br.mauricio.literArula.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(
        @JsonAlias("name") String nome,
        @JsonAlias("birth_year") String anoDeNascimento,
        @JsonAlias("death_year") String anoDeFalecimento
) {
}

//private LocalDate anoDeNascimento;
//private LocalDate anoDeFalecimento;

//@Column(name = "nome", nullable = false)
//private String nome;
//
//@Column(name = "ano_de_nascimento")
//private Integer anoDeNascimento; // Assuming birth year is stored as an integer
//
//@Column(name = "ano_de_falecimento")
//private Integer anoDeFalecimento; // Assuming death year is stored as an integer



    //
    //{
    //        "count": 1,
    //        "next": null,
    //        "previous": null,
    //        "results": [
    //        {
    //        "id": 55752,
    //        "title": "Dom Casmurro",
    //        "authors": [
    //        {
    //        "name": "Machado de Assis",
    //        "birth_year": 1839,
    //        "death_year": 1908
    //        }
    //        ],
    //        "translators": [],
    //        "subjects": [
    //        "Adultery -- Fiction",
    //        "Authorship -- Fiction",
    //        "Catholic Church -- Fiction",
    //        "Reminiscing in old age -- Fiction"
    //        ],
    //        "bookshelves": [],
    //        "languages": [
    //        "pt"
    //        ],
    //        "copyright": false,
    //        "media_type": "Text",
    //        "formats": {
    //        "text/plain; charset=us-ascii": "https://www.gutenberg.org/ebooks/55752.txt.utf-8",
    //        "text/html": "https://www.gutenberg.org/ebooks/55752.html.images",
    //        "text/html; charset=iso-8859-1": "https://www.gutenberg.org/files/55752/55752-h/55752-h.htm",
    //        "application/epub+zip": "https://www.gutenberg.org/ebooks/55752.epub3.images",
    //        "application/x-mobipocket-ebook": "https://www.gutenberg.org/ebooks/55752.kf8.images",
    //        "text/plain; charset=iso-8859-1": "https://www.gutenberg.org/files/55752/55752-8.txt",
    //        "application/rdf+xml": "https://www.gutenberg.org/ebooks/55752.rdf",
    //        "image/jpeg": "https://www.gutenberg.org/cache/epub/55752/pg55752.cover.medium.jpg",
    //        "application/octet-stream": "https://www.gutenberg.org/cache/epub/55752/pg55752-h.zip"
    //        },
    //        "download_count": 915
    //        }
    //        ]
    //        }