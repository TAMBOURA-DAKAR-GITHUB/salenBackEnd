package com.slaen.salen.Exception;


import org.springframework.web.bind.annotation.ControllerAdvice;


public class MairieNotFoundException extends RuntimeException{

    public MairieNotFoundException(String message){
        super(message);
    }
}
