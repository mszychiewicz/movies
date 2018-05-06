package com.mszychiewicz.movies;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "account")
    private Set<Movie>movies = new HashSet<>();

    private Account() { }

    Account(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Movie> getMovies() {
        return movies;
    }
}