package com.slaen.salen.Exception.Message.Existance;


import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionExistance.RegionExistetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RegionExceptionVerification
{
    @ExceptionHandler(value = RegionExistetException.class)
    public ResponseEntity<Object> exception(RegionExistetException exception)
    {
        return new ResponseEntity<>("La Region Existe daja ......", HttpStatus.BAD_REQUEST);
    }
}
