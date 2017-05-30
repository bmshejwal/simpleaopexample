package com.examples.com;

public class EntityNotFoundException extends Throwable {
    final private String errorMessage;
    public EntityNotFoundException(final String s) {
        this.errorMessage = s;
    }
}
