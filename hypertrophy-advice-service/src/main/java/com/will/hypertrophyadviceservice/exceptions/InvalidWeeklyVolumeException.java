package com.will.hypertrophyadviceservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidWeeklyVolumeException extends IllegalStateException {

  public InvalidWeeklyVolumeException(String message){
    super(message);
  }
}
