package com.mszychiewicz.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Collection<Movie> findByAccountUsername(String username);
}
