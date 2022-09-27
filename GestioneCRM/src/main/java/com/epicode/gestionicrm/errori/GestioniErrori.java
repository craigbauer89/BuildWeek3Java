package com.epicode.gestionicrm.errori;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GestioniErrori extends ResponseEntityExceptionHandler {

	 
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<String> gestisciEntityNotFoundException(EntityNotFoundException e) {
		log.info("---------da gestioni di errori-----------");
		return new ResponseEntity<String>(e.getMessage() + "----------da gestioni di errori", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EntityExistsException.class)
	protected ResponseEntity<String> gestisciEntityExistsException(EntityExistsException e) {
		log.info("---------da gestioni di errori-----------");
		return new ResponseEntity<String>(e.getMessage() + "---------da gestioni di errori", HttpStatus.FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity validationHandler(ConstraintViolationException ex) {
		
		
		Set<String> errori = new HashSet<String>();
		for(ConstraintViolation errore :ex.getConstraintViolations()) {
			errori.add(errore.getPropertyPath() +" " + errore.getMessage());
		}
		
//		log.info(ex.toString());
//		return ResponseEntity.ok("Errore in validazione");
		return new ResponseEntity<Set<String>> (errori, HttpStatus.BAD_REQUEST);
	}

}
