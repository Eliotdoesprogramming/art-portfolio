package com.talentpath.artportfolio.exceptions;

public class InvalidIndexException extends Exception{
    public InvalidIndexException (String message){
        super(message);
    }
    public InvalidIndexException (String message, Throwable innerException){
        super(message,innerException);
    }
}
