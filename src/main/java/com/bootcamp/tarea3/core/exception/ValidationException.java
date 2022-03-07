package com.bootcamp.tarea3.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ValidationException extends RuntimeException{
    public ValidationException(String reason){
        super(reason);
    }
}
