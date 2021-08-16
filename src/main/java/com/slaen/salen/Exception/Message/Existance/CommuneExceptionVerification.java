package com.slaen.salen.Exception.Message.Existance;


import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionExistance.CommuneExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CommuneExceptionVerification
{
    @ExceptionHandler(value = CommuneExistetException.class)
    public ResponseEntity<Object> exception(CommuneExistetException exception)
    {
        return new ResponseEntity<>("La Commune Existe daja ......", HttpStatus.BAD_REQUEST);
    }
}
