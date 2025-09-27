package com.akashjayaraj.parkingsystem.exception;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
