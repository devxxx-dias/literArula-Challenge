package br.mauricio.literArula.service;

import br.mauricio.literArula.model.DadosAutor;
import br.mauricio.literArula.model.DadosLivro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

public class ConverterTeste {
    public DadosAutor autor;
    public DadosLivro livro;

    public DadosAutor obterDadosJson(String url) {

        ObjectMapper mapper = new ObjectMapper();


        try {
            JsonNode rootNode = mapper.readTree(new URL(url));

            System.out.println("Teste dentro de conveter rootNode" + rootNode);

            // Access the "results" array
            JsonNode resultsNode = rootNode.get("results");

            System.out.println("Dentro do converter Teste" + resultsNode);

// Loop through each result object (book)
            if (resultsNode != null) {
                for (JsonNode resultNode : resultsNode) {
                    String titulo = resultNode.get("title").asText();
                    String dowloads = resultNode.get("download_count").asText();
                    String languageNode = resultNode.get("languages").asText();

                    
                    // Access the "authors" array inside the current result
                    JsonNode authorsNode = resultNode.get("authors");



                    // Loop through each author object
                    for (JsonNode authorNode : authorsNode) {
                        // Extract author information using JsonNode methods
                        String nome = authorNode.get("name").asText();

                        String anoDeNascimentoString = authorNode.get("birth_year").asText();
                        String anoDeFalecimentoString = authorNode.get("death_year").asText();



                        String anoDeNascimento = anoDeNascimentoString;
                        String anoDeFalecimento = anoDeFalecimentoString;

                        // Create a DadosAutor object with extracted data
                        autor = new DadosAutor(nome, anoDeNascimento, anoDeFalecimento);

                        // Use the DadosAutor object (e.g., print its attributes)
                        System.out.println("Nome: " + autor);


                    }
                }

            }
            return autor;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


//@JsonIgnoreProperties(ignoreUnknown = true)
//public record DadosLivro(
//        Long id,
//        @JsonAlias("title") String titulo,
//        @JsonAlias("name") String autor,
//        @JsonAlias("languages") String idiomas,
//        @JsonAlias("download_count") String downloads
//) {}