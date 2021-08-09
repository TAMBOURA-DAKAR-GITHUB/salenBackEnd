package com.slaen.salen.Exception.Message;


import com.slaen.salen.Exception.InterceptionException.MarcherNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MarcherException {

    @ExceptionHandler(value = MarcherNotFountException.class)
    public ResponseEntity<Object> exception(MarcherNotFountException exception)
    {
        return new ResponseEntity<>("pas de Marcher trouver ....", HttpStatus.NOT_FOUND);
    }
}
