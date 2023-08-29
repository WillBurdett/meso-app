package com.will.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class WeekDoesNotExistException extends RuntimeException{

  public WeekDoesNotExistException(String message){
    super(message);
  }

}
