package com.slaen.salen.Exception.Message.MessageSimple;


import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.MairieNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;





@ControllerAdvice
public class MairieException
{
    @ExceptionHandler(value = MairieNotFountException.class)
    public ResponseEntity<Object> exception(MairieNotFountException exception)
    {
        return new ResponseEntity<>("erreur d'execution de la requete ....", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
