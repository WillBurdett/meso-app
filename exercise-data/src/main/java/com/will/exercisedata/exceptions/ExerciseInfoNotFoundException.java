package com.will.exercisedata.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExerciseInfoNotFoundException extends IllegalStateException {

  public ExerciseInfoNotFoundException(String message){
    super(message);
  }
}
