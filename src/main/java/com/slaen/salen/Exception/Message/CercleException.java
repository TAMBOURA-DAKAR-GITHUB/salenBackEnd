package com.slaen.salen.Exception.Message;


import com.slaen.salen.Exception.InterceptionException.CercleNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class CercleException {

    @ExceptionHandler(value = CercleNotFountException.class)
    public ResponseEntity<Object> exception(CercleNotFountException exception)
    {
        return new ResponseEntity<>("pas de Cercle trouver ....", HttpStatus.NOT_FOUND);
    }
}
