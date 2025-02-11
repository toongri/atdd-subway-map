package subway.subway.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Objects;


@RestControllerAdvice(annotations = RestController.class)
public class ExControllerAdvice {


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler
  public ResponseEntity<String> exHandler(RuntimeException e) {

    return ResponseEntity.badRequest().body(e.getMessage());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler
  public ResponseEntity<String> exHandler(Exception e) {
    return ResponseEntity.internalServerError().body(e.getMessage());
  }

}
