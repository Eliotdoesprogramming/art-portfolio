package com.talentpath.artportfolio.exceptions;

public class InvalidEnumException extends Exception {
    public InvalidEnumException(String message){
        super(message);
    }
    public InvalidEnumException(String message, Throwable innerException){
        super(message,innerException);
    }
}
