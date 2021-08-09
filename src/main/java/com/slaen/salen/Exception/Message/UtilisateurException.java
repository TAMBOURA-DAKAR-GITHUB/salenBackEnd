package com.slaen.salen.Exception.Message;


import com.slaen.salen.Exception.InterceptionException.UtilisateurNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UtilisateurException {

    @ExceptionHandler(value = UtilisateurNotFountException.class)
    public ResponseEntity<Object> exception(UtilisateurNotFountException exception)
    {
        return new ResponseEntity<>("pas de Utilisateur trouver ....", HttpStatus.NOT_FOUND);
    }
}
