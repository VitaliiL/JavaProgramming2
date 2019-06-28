package com.course.lapshakov.sem5.Exception;

public class MyException extends Throwable {
    private String message;

    public MyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
