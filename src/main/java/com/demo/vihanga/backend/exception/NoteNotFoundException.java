package com.demo.vihanga.backend.exception;

public class NoteNotFoundException extends RuntimeException{

	public NoteNotFoundException(String message) {
		super(message);
	}

}
