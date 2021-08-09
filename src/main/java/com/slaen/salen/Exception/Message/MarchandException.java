package com.slaen.salen.Exception.Message;


import com.slaen.salen.Exception.InterceptionException.MarchandNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MarchandException {

    @ExceptionHandler(value = MarchandNotFountException.class)
    public ResponseEntity<Object> exception(MarchandNotFountException exception)
    {
        return new ResponseEntity<>("pas de Marchand trouver ....", HttpStatus.NOT_FOUND);
    }
}
