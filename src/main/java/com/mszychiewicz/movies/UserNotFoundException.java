package com.mszychiewicz.movies;

class UserNotFoundException extends RuntimeException {

	UserNotFoundException(String userId) {
		super("could not find user '" + userId + "'.");
	}
}