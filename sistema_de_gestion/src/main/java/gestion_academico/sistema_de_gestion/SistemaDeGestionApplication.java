package gestion_academico.sistema_de_gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "gestion_academico.sistema_de_gestion.repository")
public class SistemaDeGestionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemaDeGestionApplication.class, args);
    }
}