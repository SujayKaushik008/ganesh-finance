package com.oracle.finance.exception;

public class ApplicationException extends RuntimeException {
	public ApplicationException() {
	}
	public ApplicationException(String msg) {
		super(msg);
	}
}
