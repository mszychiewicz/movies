package com.mszychiewicz.movies;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

class MovieResource extends ResourceSupport {

	private final Movie movie;

	MovieResource(Movie movie) {
		String username = movie.getAccount().getUsername();
		this.movie = movie;
		this.add(new Link(movie.getTitle(), "movie-title"));
		this.add(linkTo(MovieRestController.class, username).withRel("movies"));
		this.add(linkTo(methodOn(MovieRestController.class, username)
				.readMovie(username, movie.getId())).withSelfRel());
	}

	public Movie getMovie() {
		return movie;
	}
}