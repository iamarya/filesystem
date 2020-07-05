package com.arya.filesystem.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This is the global exception handler. 
 * @author arya
 *
 */
@ControllerAdvice
public class ErrorHandler {
	@ExceptionHandler({Exception.class})
	  public String databaseError() {
	    return "error";
	  }
}
