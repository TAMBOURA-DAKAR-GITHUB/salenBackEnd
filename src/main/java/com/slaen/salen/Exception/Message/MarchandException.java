package com.slaen.salen.Exception.Message;


import com.slaen.salen.Exception.InterceptionException.MarchandNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MarchandException {

    @ExceptionHandler(value = MarchandNotFountException.class)
    public ResponseEntity<Object> exception(MarchandNotFountException exception)
    {
        return new ResponseEntity<>("erreur d'execution de la requete ....", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
