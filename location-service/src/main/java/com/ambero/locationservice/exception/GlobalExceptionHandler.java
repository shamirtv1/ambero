package com.ambero.locationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /*@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        ErrorRequestExceptionModel error = ErrorRequestExceptionModel.builder()
                .status_code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST)
                .message(errors.get(0))
                .timestamp(LocalDateTime.now())
                .uriRequested(((ServletWebRequest)request).getRequest().getRequestURI().toString())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }*/

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorRequestExceptionModel> requestExceptionHandler(
            RequestException ex, HttpServletRequest httpRequest) {

        ErrorRequestExceptionModel error = ErrorRequestExceptionModel.builder()
                .status_code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .uriRequested(httpRequest.getRequestURI().toString())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}