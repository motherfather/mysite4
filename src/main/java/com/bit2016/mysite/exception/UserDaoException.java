package com.bit2016.mysite.exception;

public class UserDaoException extends RuntimeException {

	public UserDaoException() {
		super("User Not Found");
	}
}
