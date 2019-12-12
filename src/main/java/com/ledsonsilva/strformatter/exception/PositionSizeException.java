package com.ledsonsilva.strformatter.exception;

public class PositionSizeException extends Exception {

    private String clazz;
    private String field;

    public PositionSizeException(String clazz, String field) {
        super(field + " :: Value exceeds noted position size");
        this.clazz = clazz;
        this.field = field;
    }

    public String getClazz() {
        return clazz;
    }

    public String getField() {
        return field;
    }
}
