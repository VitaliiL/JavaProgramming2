package com.course.lapshakov.sem5.exceptionInterface;

import com.course.lapshakov.sem5.Exception.MyException;

public interface ExceptionGenerator {
    void generateNullPointerException();

    void generateClassCastException();

    void generateNumberFormatException();

    void generateStackOverflowException();

    void generateOutOfMemoryException();

    void generateMyException(String message) throws MyException;
}

