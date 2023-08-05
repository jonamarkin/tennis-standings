package com.ato.tennis_standings.exception;

import com.ato.tennis_standings.dto.ErrorDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class PlayerExceptionHandler {

  @ExceptionHandler(value = {Exception.class})
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorDTO handleException(Exception exception) {
    log.error("Exception: {}", exception.getMessage());
    return new ErrorDTO(
        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Internal Server Error");
  }

  @ResponseBody
  @ExceptionHandler(value = {ValidationException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDTO handleException(ValidationException validationException){
    ErrorDTO errorDTO;

    if(validationException instanceof ConstraintViolationException){
      String violations = extractViolationsFromException((ConstraintViolationException) validationException);
      log.error(violations, validationException);
      errorDTO = ErrorDTO.builder().code(HttpStatus.BAD_REQUEST.getReasonPhrase()).message(violations).build();
    }else{
      String exceptionMessage = validationException.getMessage();
      log.error(exceptionMessage, validationException);
      errorDTO = ErrorDTO.builder().code(HttpStatus.BAD_REQUEST.getReasonPhrase()).message(exceptionMessage).build();
    }

    return errorDTO;
  }

  private String extractViolationsFromException(ConstraintViolationException validationException) {
    return validationException.getConstraintViolations().stream().map(
            ConstraintViolation::getMessage
    ).collect(Collectors.joining("--"));
  }
}
