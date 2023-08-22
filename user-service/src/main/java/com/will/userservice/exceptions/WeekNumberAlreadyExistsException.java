package com.will.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WeekNumberAlreadyExistsException extends RuntimeException{

  public WeekNumberAlreadyExistsException(String message){
    super(message);
  }

}
