package com.concessionariaapi.concessionariaapi.exception;

public class CarsNotFound extends RuntimeException{
    public CarsNotFound(String message) {
        super(message);
    }
}
