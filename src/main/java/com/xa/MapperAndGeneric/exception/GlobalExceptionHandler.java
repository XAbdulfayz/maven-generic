package com.xa.MapperAndGeneric.exception;

import com.xa.MapperAndGeneric.response.APIErrorDTO;
import com.xa.MapperAndGeneric.response.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Data<APIErrorDTO>> notFoundException(NotFoundException ex, WebRequest request){
        APIErrorDTO path = APIErrorDTO.builder().developerMessage(ex.getStackTrace().toString()).message(ex.getMessage()).status(HttpStatus.NOT_FOUND.value()).path(request.getContextPath()).build();
        return new ResponseEntity<>(new Data<>(path), HttpStatus.OK);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Data<APIErrorDTO>> runtimeException(RuntimeException ex, WebRequest request){
        APIErrorDTO path = APIErrorDTO.builder().developerMessage(ex.getStackTrace().toString()).message(ex.getMessage()).status(HttpStatus.BAD_REQUEST.value()).path(request.getContextPath()).build();
        return new ResponseEntity<>(new Data<>(path), HttpStatus.OK);
    }






}
