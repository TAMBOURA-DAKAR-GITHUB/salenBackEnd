package com.slaen.salen.Exception.Message;

import com.slaen.salen.Exception.InterceptionException.AffecterPlaceMarchandNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AffecterPlaceMarchandException {

    @ExceptionHandler(value = AffecterPlaceMarchandNotFountException.class)
    public ResponseEntity<Object> exception(AffecterPlaceMarchandNotFountException exception)
    {
        return new ResponseEntity<>("impossible ....", HttpStatus.NOT_FOUND);
    }
}
