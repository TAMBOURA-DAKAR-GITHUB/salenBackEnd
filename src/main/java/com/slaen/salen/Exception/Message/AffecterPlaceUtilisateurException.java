package com.slaen.salen.Exception.Message;


import com.slaen.salen.Exception.InterceptionException.AffecterPlaceUtilisateurNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AffecterPlaceUtilisateurException {

    @ExceptionHandler(value = AffecterPlaceUtilisateurNotFountException.class)
    public ResponseEntity<Object> exception(AffecterPlaceUtilisateurNotFountException exception)
    {
        return new ResponseEntity<>("impossible ....", HttpStatus.NOT_FOUND);
    }
}
