package com.talentpath.artportfolio.exceptions;

public class InvalidCharacterException extends Exception {
    public InvalidCharacterException(String m){
        super (m);
    }
    public InvalidCharacterException (String m, Throwable e){
        super(m,e);
    }
}
