package com.slaen.salen.Exception.Message.Existance;


import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionExistance.CercleExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CercleExceptionVerification
{
    @ExceptionHandler(value = CercleExistetException.class)
    public ResponseEntity<Object> exception(CercleExistetException exception)
    {
        return new ResponseEntity<>("La Cercle Existe daja ......", HttpStatus.BAD_REQUEST);
    }
}
