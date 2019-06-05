package com.course.lapshakov.sem2.main;

import com.course.lapshakov.sem2.converToPolishNotation.PolishNotation;

import java.util.Scanner;

//  2 + 3 * 5 - 7

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input expression:");

        String scannerString = scanner.nextLine();
        String polishNotation = PolishNotation.ExpressionToPolishNotation(scannerString);

        System.out.println(polishNotation);
    }
}
