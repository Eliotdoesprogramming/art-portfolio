package com.talentpath.artportfolio.exceptions;

public class NullExpectedFieldException extends Exception {
    public NullExpectedFieldException(String message){
        super(message);
    }
    public NullExpectedFieldException(String message, Throwable innerException){
        super (message,innerException);
    }
}
