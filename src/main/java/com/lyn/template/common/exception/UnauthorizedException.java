package com.lyn.template.common.exception;

public class UnauthorizedException extends RuntimeException {
	
	public UnauthorizedException(String msg) {
		super(msg);
	}
	public UnauthorizedException() {
		super();
	}
}