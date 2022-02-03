package com.getabook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GetABookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetABookApplication.class, args);
	}

	/*
	// metoda w kontrollerze ktora przyjmuje dtosa i go wyswietla
	1. rest createAdministrator. Chlop ma konto. trzeba nadac mu adminitratoer.
	usera wyszukuje po mailu. POST(email, companyId)

	-nadawanie użytkownikowi odpowiedniej roli.
	-Użytkownik musi mieć zarejestrowane
	konto
	-Użytkownik musi nie być przypisanym do żadnej firmy. Security: dostęp tylko dla admina serwera.
	*/
}
