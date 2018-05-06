package com.mszychiewicz.movies.rest;

class UserNotFoundException extends RuntimeException {

	UserNotFoundException(String userId) {
		super("could not find user '" + userId + "'.");
	}
}