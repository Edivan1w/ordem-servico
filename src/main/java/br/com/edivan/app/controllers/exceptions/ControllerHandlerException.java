package br.com.edivan.app.controllers.exceptions;



import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.edivan.app.model.StandardError;
import br.com.edivan.app.service.exceptions.DataIntegratyViolationException;
import br.com.edivan.app.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ControllerHandlerException {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException exception, HttpServletRequest request){
		StandardError error = new StandardError(
				System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegratyViolationException.class)
	public ResponseEntity<StandardError> dataIntegratyViolationException(DataIntegratyViolationException exception, HttpServletRequest request){
		StandardError error = new StandardError(
				System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request){
		ValidationErros error = new ValidationErros(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Campos obrigatorios não preenchidos");
		
		exception.getBindingResult().getFieldErrors().forEach(er -> error.addError(er.getField(), er.getDefaultMessage()));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
