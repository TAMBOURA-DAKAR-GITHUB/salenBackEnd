package com.slaen.salen.Exception.Message;


import com.slaen.salen.Exception.InterceptionException.PlaceNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PlaceException {

    @ExceptionHandler(value = PlaceNotFountException.class)
    public ResponseEntity<Object> exception(PlaceNotFountException exception)
    {
        return new ResponseEntity<>("pas de place trouver ....", HttpStatus.NOT_FOUND);
    }
}
