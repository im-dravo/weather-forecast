package com.weather.infra.api.rest;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.weather.api.model.ErrorDTO;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
		ErrorDTO error = new ErrorDTO("Bad Request",
				Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}