package com.learninggeeks.profileblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicantRestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ApplicantErrorResponse> handleException(ApplicantNotFoundException exec){
		ApplicantErrorResponse err = new ApplicantErrorResponse(HttpStatus.NOT_FOUND.value(),exec.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
}
