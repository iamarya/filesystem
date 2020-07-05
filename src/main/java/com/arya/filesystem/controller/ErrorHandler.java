package com.arya.filesystem.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	@ExceptionHandler({Exception.class})
	  public String databaseError() {
	    return "error";
	  }
}
