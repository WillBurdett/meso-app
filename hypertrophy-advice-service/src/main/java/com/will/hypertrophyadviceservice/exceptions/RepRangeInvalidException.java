package com.will.hypertrophyadviceservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RepRangeInvalidException extends IllegalStateException {

  public RepRangeInvalidException(String message){
    super(message);
  }
}
