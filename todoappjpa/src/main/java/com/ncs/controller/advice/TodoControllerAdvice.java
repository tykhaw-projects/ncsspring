package com.ncs.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ncs.exception.ErrorResponse;
import com.ncs.exception.TodoIDMismatchException;
import com.ncs.exception.TodoNotFoundException;

@RestControllerAdvice
public class TodoControllerAdvice {

	 @ExceptionHandler(TodoNotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleTodoNotFound(TodoNotFoundException e)
	 {
		 
		 ErrorResponse er= new ErrorResponse("TODO-404", "Todo with the specified ID Not found!", new Date());
		  return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	 }
	 
	 @ExceptionHandler(TodoIDMismatchException.class)
	 public ResponseEntity<ErrorResponse> handleTodoIDMismatch(TodoIDMismatchException e)
	 {
		 
		 ErrorResponse er= new ErrorResponse("TODO-400", "Todo with the specified ID Does Not Match!", new Date());
		  return new ResponseEntity<ErrorResponse>(er,HttpStatus.BAD_REQUEST);
	 }
}
