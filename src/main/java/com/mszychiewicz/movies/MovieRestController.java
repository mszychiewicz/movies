package com.mszychiewicz.movies;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/{userId}/movies")
class MovieRestController {

	private final MovieRepository movieRepository;

	private final AccountRepository accountRepository;

    MovieRestController(MovieRepository movieRepository,
						AccountRepository accountRepository) {
        this.movieRepository = movieRepository;
        this.accountRepository = accountRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
	Resources<MovieResource> readMovie(@PathVariable String userId) {

		this.validateUser(userId);

		List<MovieResource> movieResourceList = movieRepository
				.findByAccountUsername(userId).stream().map(MovieResource::new)
				.collect(Collectors.toList());

		return new Resources<>(movieResourceList);
	}

	@RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@PathVariable String userId, @RequestBody Movie input) {

		this.validateUser(userId);

		return accountRepository.findByUsername(userId)
            .map(account -> {
                Movie movie = movieRepository
                        .save(new Movie(account, input.getTitle(), input.getDescription()));

                Link forOneMovie = new MovieResource(movie).getLink("self");

                return ResponseEntity.created(URI.create(forOneMovie.getHref())).build();
            })
            .orElse(ResponseEntity.noContent().build());
	}

    @RequestMapping(method = RequestMethod.GET, value = "/{movieId}")
    MovieResource readMovie(@PathVariable String userId,
                            @PathVariable Long movieId) {
        this.validateUser(userId);
        return new MovieResource(this.movieRepository.findById(movieId).orElse(null));
    }

	private void validateUser(String userId) {
		this.accountRepository
			.findByUsername(userId)
			.orElseThrow(() -> new UserNotFoundException(userId));
	}
}