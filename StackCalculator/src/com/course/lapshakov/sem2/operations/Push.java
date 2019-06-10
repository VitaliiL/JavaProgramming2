package com.course.lapshakov.sem2.operations;

import com.course.lapshakov.sem2.interfaces.ArithmeticCommand;
import com.course.lapshakov.sem2.interfaces.Command;
import com.course.lapshakov.sem2.interfaces.DefineCommand;
import com.course.lapshakov.sem2.interfaces.StackCommand;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Push implements StackCommand, ArithmeticCommand, DefineCommand {
    private Stack<Double> stack;
    private String[] arguments;
    private Map<String, Double> variables;
    private Define define;

    public Push() {
    }

    private Push(String[] arguments, Stack<Double> stack) {
        this.stack = stack;
        this.arguments = arguments;
    }

    @Override
    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setString(String[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public void setMap(Map<String, Double> variables) {
        this.variables = variables;
    }

    @Override
    public String getCommandName() {
        return "Push";
    }

    @Override
    public Push getCommandObject() {
        return new Push(arguments, stack);
    }

    @Override
    public void executeCommand() throws EmptyStackException, NumberFormatException {
        char [] charsArray = arguments[1].toCharArray();

        for(int i = 0; i< charsArray.length; i++) {
            if (Character.isDigit(charsArray[i])){
                stack.push(Double.parseDouble(arguments[1]));
            }else{
               // stack.push(define.)
            }

        }
    }


}
