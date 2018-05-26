package nl.codebase.entities.common.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j

public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        final RestValidationError restValidationError = new RestValidationError();

        ex.getBindingResult().getAllErrors().forEach(e -> {
            if (e instanceof FieldError) {
                FieldError fieldError = (FieldError) e;
                RestValidationError.FieldValidationError fieldValidationError =
                        new RestValidationError.FieldValidationError(fieldError.getField(), fieldError.getRejectedValue().toString());
                restValidationError.addError(fieldValidationError);
            }
        });

        return new ResponseEntity<>(restValidationError, HttpStatus.BAD_REQUEST);
    }
}