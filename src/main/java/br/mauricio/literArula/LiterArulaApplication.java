package br.mauricio.literArula;

import br.mauricio.literArula.principal.Principal;
import br.mauricio.literArula.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan(basePackages = "br.mauricio.literArula.model" )
@SpringBootApplication
public class LiterArulaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LiterArulaApplication.class, args);
    }

    @Autowired
    private AutorRepository repository;

    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal(repository);
        principal.exibirMenuInicial();

    }
}
