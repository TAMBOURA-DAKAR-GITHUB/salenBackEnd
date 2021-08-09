package com.slaen.salen.Exception.Message;


import com.slaen.salen.Exception.InterceptionException.RegionNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class RegionException {

    @ExceptionHandler(value = RegionNotFountException.class)
    public ResponseEntity<Object> exception(RegionNotFountException exception)
    {
        return new ResponseEntity<>("pas de Region trouver ....", HttpStatus.NOT_FOUND);
    }
}
