package com.course.lapshakov.sem5.tests;

import com.course.lapshakov.sem5.Exception.MyException;
import com.course.lapshakov.sem5.main.Generator;
import org.junit.Before;
import org.junit.Test;

public class GeneratorTest {
    private Generator generator;

    @Before
    public void createGeneratorObject() {
        generator = new Generator();
    }

    @Test(expected = NullPointerException.class)
    public void getNullPointerException() {
        generator.generateNullPointerException();
    }

    @Test(expected = ClassCastException.class)
    public void getClassCastException() {
        generator.generateClassCastException();
    }

    @Test(expected = NumberFormatException.class)
    public void getNumberFormatException() {
        generator.generateNumberFormatException();
    }

    @Test(expected = StackOverflowError.class)
    public void getStackOverflowException() {
        generator.generateStackOverflowException();
    }

    @Test(expected = OutOfMemoryError.class)
    public void getOutOfMemoryException() {
        generator.generateOutOfMemoryException();
    }

    @Test(expected = MyException.class)
    public void getMyException() throws MyException {
        generator.generateMyException("exception");
    }
}