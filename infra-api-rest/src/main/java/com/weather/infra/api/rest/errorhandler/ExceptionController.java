package com.weather.infra.api.rest.errorhandler;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.weather.api.model.ApiConstants.APP_ERROR_CODES;
import com.weather.api.model.ErrorDTO;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
		ErrorDTO error = new ErrorDTO("Bad Request",
				Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage(),
				APP_ERROR_CODES.ERR400);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResponseStatusException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	protected ResponseEntity<ErrorDTO> handleResponseExceptions(ResponseStatusException e) {
		ErrorDTO error = new ErrorDTO("Not Found", Objects.requireNonNull(e.getMessage()), APP_ERROR_CODES.ERR404);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}