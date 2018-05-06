package com.mszychiewicz.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Account account;

    private String title;

    private String description;

    private Movie() { }

    public Movie(final Account account, final String title, final String description) {
        this.title = title;
        this.description = description;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
