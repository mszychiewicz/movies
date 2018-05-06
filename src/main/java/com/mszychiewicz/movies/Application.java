package com.mszychiewicz.movies;

import com.mszychiewicz.movies.model.Account;
import com.mszychiewicz.movies.model.AccountRepository;
import com.mszychiewicz.movies.model.Movie;
import com.mszychiewicz.movies.model.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, MovieRepository movieRepository) {
		return (args) ->
				Arrays.asList("jbutton,lhamilton,pmaldonado,fmassa,nrosberg,svettel".split(","))
						.forEach(a -> {
							Account account = accountRepository.save(new Account(a, "password"));
							movieRepository.save(new Movie(account, "Drive", "A movie description"));
							movieRepository.save(new Movie(account, "12 Angry Men", "A movie description"));
						});
	}
}