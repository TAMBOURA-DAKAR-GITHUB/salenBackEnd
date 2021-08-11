package com.slaen.salen.Exception.Message;


import com.slaen.salen.Exception.InterceptionException.PayementNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PayementException {

    @ExceptionHandler(value = PayementNotFountException.class)
    public ResponseEntity<Object> exception(PayementNotFountException exception)
    {
        return new ResponseEntity<>("pas de Payement trouver ....", HttpStatus.NOT_FOUND);
    }
}