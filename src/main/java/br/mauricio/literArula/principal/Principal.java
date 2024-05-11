package br.mauricio.literArula.principal;

import br.mauricio.literArula.model.*;
import br.mauricio.literArula.repository.AutorRepository;

import br.mauricio.literArula.service.ObterDados;

import java.util.*;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://gutendex.com/books?search=";
    private List<Livros> livrosList = new ArrayList<>();
    private AutorRepository repository;


    public Principal(AutorRepository repository) {
        this.repository = repository;
    }

    public void exibirMenuInicial() {
        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                    _______________________________
                    Escolha o número da sua opção:
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    0 - Sair
                                        
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();


            switch (opcao) {
                case 1:
                    buscarLivroPorTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegitrados();
                    break;
                case 4:
                    listarAutoresVivosPeloAno();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o nosso sistema... :) ");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }


    private void buscarLivroPorTitulo() {
        System.out.println("Insira o nome do livro que você deseja procurar:");
        var tituloLivro = leitura.nextLine();
        var endereco = ENDERECO + tituloLivro.replace(" ", "+");
        System.out.println(endereco);
        ObterDados extrairDados = new ObterDados(endereco);
        DadosAutor dadosAutor = extrairDados.obterDadosAutor();
        Autor autor = new Autor(dadosAutor);
        DadosLivro dadosLivro = extrairDados.obterDadosLivro();
        Livros livro = new Livros(dadosLivro);
        livrosList.add(livro);
        autor.setLivros(livrosList);
        repository.save(autor);
        System.out.println("----- LIVRO -----");
        System.out.println(livro);
        System.out.println("----------------------");
    }

    private void listarLivrosRegistrados() {
        List<Livros> lista = repository.listarLivroRegistrados();
        lista.forEach(System.out::println);
    }

    private void listarAutoresRegitrados() {
        List<Autor> listaAutores = repository.listarAutoresRegitrados();
        listaAutores.forEach(System.out::println);
    }

    private void listarAutoresVivosPeloAno() {
        System.out.println("Digite a ano de busca desejado para listarmos os autores vivos desse ano:");
        int ano = leitura.nextInt();
        leitura.nextLine();
        List<Autor> lista = repository.listarAutoresVivosPeloAno(ano);
        lista.forEach(System.out::println);
    }

    private void listarLivrosPorIdioma() {
        System.out.println("Insira o idioma para realizar a busca: \n" +
                "pt - português \n" +
                "en - inglês \n" +
                "fr - francês \n" +
                "es - espanhol \n"
        );
        String idioma = leitura.nextLine();

        List<Livros> listaPorIdioma = repository.listarLivrosPorIdioma( Idiomas.fromString(idioma));
        if(listaPorIdioma.size() == 0){
            System.out.println("Não existem livros nesse idioma no banco de dados");
        }else{
            listaPorIdioma.forEach(System.out::println);
        }

    }


}


//LANGUAGE = "?languages=en";