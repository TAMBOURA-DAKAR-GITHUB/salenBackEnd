package com.slaen.salen.Exception.Message;


import com.slaen.salen.Exception.InterceptionException.CommuneNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CommuneException {

    @ExceptionHandler(value = CommuneNotFountException.class)
    public ResponseEntity<Object> exception(CommuneNotFountException exception)
    {
        return new ResponseEntity<>("pas de Commune trouver ....", HttpStatus.NOT_FOUND);
    }
}
