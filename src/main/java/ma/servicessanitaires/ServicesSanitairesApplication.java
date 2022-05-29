package ma.servicessanitaires;

import ma.servicessanitaires.entities.Medecin;
import ma.servicessanitaires.entities.Specialite;
import ma.servicessanitaires.repositories.MedecinRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ServicesSanitairesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesSanitairesApplication.class, args);
	}
}
