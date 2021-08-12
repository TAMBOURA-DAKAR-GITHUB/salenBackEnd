package com.slaen.salen.Exception.Message;

import com.slaen.salen.Exception.InterceptionException.AffecterPlaceMarchandNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AffecterPlaceMarchandException {

    @ExceptionHandler(value = AffecterPlaceMarchandNotFountException.class)
    public ResponseEntity<Object> exception(AffecterPlaceMarchandNotFountException exception)
    {
        return new ResponseEntity<>("erreur d'execution de la requete ....", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
