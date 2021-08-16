package com.slaen.salen.Exception.Message.Existance;


import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionExistance.UtilisateurExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UtilisateurExceptionVerification
{
    @ExceptionHandler(value = UtilisateurExistetException.class)
    public ResponseEntity<Object> exception(UtilisateurExistetException exception)
    {
        return new ResponseEntity<>("L ' Utilisateur Existe daja ......", HttpStatus.BAD_REQUEST);
    }
}
