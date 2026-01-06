package org.ssupstart.API.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException() {
        super("car not found");
    }
}
