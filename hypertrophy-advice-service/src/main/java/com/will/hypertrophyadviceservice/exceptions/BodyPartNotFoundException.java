package com.will.hypertrophyadviceservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BodyPartNotFoundException extends IllegalStateException {

  public BodyPartNotFoundException(String message){
    super(message);
  }
}
