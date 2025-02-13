package com.onetoone.exception;

public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException() {
	  super("Record does not exist");
	}
	public RecordNotFoundException(String string) {
		super(string);
	}
	

}
