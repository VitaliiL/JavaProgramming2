package com.course.lapshakov.sem2.arithmeticOperations;

import com.course.lapshakov.sem2.interfaces.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DefineCommand implements Command {
    String[] arguments;
    Map<String, Double> variables = new HashMap<>();
    Stack<Double> stack = new Stack<>();


    public DefineCommand(String[] arguments, Map<String, Double> variables) {
        this.arguments = arguments;
        this.variables = variables;
    }

    @Override
    public void execute() {
        //arguments - [a, 4]
        try {
            double variableValue = Double.parseDouble(arguments[1]);
            String variableName = arguments[0];
            variables.put(variableName, variableValue); //положить элемент в Map
            variables.get(variableName); // достать элемент из Map
            stack.push(0.5); //положить элемент
            stack.pop(); //извлечь элемент
            stack.peek(); //посмотреть первый элемент на стеке не извлекая его
        } catch (Exception e) {
            System.out.println();
        }
    }
}
