package com.cisco.prj.api;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex){
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("time", new Date());
		body.put("message", ex.getMessage());
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND); // 404
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("time", new Date());
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(message -> message.getDefaultMessage())
				.collect(Collectors.toList());
		body.put("errors", errors);
		return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST); // 400
	}
}
