package com.assignment.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="Costemer is already exists")
public class AlreadyExist extends RuntimeException {
}
