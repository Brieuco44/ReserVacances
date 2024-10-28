package fr.reservacances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReserVacancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReserVacancesApplication.class, args);
		System.out.println("+-----------------------------+");
		System.out.println("| Bienvenue sur ReserVacances |");
		System.out.println("+-----------------------------+");
	}
}