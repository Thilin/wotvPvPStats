package com.example.mxhStudio.WotVPvPStats.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String visioncard_not_found) {
        super(visioncard_not_found);
    }
}
