package com.course.lapshakov.sem2.interfaces;

import java.util.Stack;

public interface ArithmeticCommand extends Command {
    void setStack(Stack<Double> stack);
}
