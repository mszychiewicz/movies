package com.mszychiewicz.movies;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Account account;

    private String title;

    private String description;

    private Movie() { }

    Movie(final Account account, final String title, final String description) {
        this.title = title;
        this.description = description;
        this.account = account;
    }

    Long getId() {
        return id;
    }

    Account getAccount() {
        return account;
    }

    String getTitle() {
        return title;
    }

    String getDescription() {
        return description;
    }
}
