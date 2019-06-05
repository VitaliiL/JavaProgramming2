package com.course.lapshakov.sem2.converToPolishNotation;

import java.util.Stack;

public class PolishNotation {
    public static String ExpressionToPolishNotation(String inString) {
        Stack<Character> charStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int priority;

        for (int i = 0; i < inString.length(); i++) {
            priority = getPriority(inString.charAt(i));

            if (priority == 0) {
                builder.append(inString.charAt(i));
            }

            if (priority == 1) {
                charStack.push(inString.charAt(i));
            }

            if (priority > 1) {
                builder.append(' ');

                while (!charStack.empty()) {
                    if (getPriority(charStack.peek()) >= priority) {
                        builder.append(charStack.pop());
                    } else {
                        break;
                    }
                }
                charStack.push(inString.charAt(i));

            }

            if (priority == -1) {
                builder.append(' ');

                while (getPriority(charStack.peek()) != 1) {
                    builder.append(charStack.pop());
                }
                charStack.pop();
            }
        }

        while (!charStack.empty()) {
            builder.append(charStack.pop());
        }

        return builder.toString();
    }

    private static int getPriority(char symbol) {
        if (symbol == '*' || symbol == '/') {
            return 3;
        } else if (symbol == '+' || symbol == '-') {
            return 2;
        } else if (symbol == '(') {
            return 1;
        } else if (symbol == ')') {
            return -1;
        } else {
            return 0;
        }
    }
}
