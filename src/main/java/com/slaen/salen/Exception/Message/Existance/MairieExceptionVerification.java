package com.slaen.salen.Exception.Message.Existance;


import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionExistance.MairieExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MairieExceptionVerification
{
    @ExceptionHandler(value = MairieExistetException.class)
    public ResponseEntity<Object> exception(MairieExistetException exception)
    {
        return new ResponseEntity<>("La Mairie Existe daja ......", HttpStatus.BAD_REQUEST);
    }
}
