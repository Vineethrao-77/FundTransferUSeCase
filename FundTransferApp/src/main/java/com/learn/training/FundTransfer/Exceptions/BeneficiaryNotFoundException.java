package com.learn.training.FundTransfer.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BeneficiaryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BeneficiaryNotFoundException(String message){
		super(message);
    	
	}}

