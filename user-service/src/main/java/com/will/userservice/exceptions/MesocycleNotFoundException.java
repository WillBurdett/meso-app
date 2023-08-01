package com.will.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MesocycleNotFoundException extends RuntimeException{

  public MesocycleNotFoundException(String message){
    super(message);
  }

}
