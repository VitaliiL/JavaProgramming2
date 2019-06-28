package com.course.lapshakov.sem5.main;

import com.course.lapshakov.sem5.Exception.MyException;
import com.course.lapshakov.sem5.exceptionInterface.ExceptionGenerator;

public class Generator implements ExceptionGenerator {
    private Generator generator;

    @Override
    public void generateNullPointerException() {
        generator.getClass();
    }

    @Override
    public void generateClassCastException() {
        String string;
        Object object = new Object();
        string = (String) object;
    }

    @Override
    public void generateNumberFormatException() {
        int value = Integer.parseInt("string");
    }

    @Override
    public void generateStackOverflowException() {
        startRecursion(1);
    }

    @Override
    public void generateOutOfMemoryException() {
        int[] longArray = new int[Integer.MAX_VALUE];
    }

    @Override
    public void generateMyException(String message) throws MyException {
        throw new MyException(message);
    }

    private static void startRecursion(int inputValue) {
        int value = inputValue;
        startRecursion(value++);
    }
}
