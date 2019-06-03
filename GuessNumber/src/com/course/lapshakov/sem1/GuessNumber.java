package com.course.lapshakov.sem1;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final int ATTEMPT_COUNT = 3;
    private static boolean checkWin;

    public static void main(String[] args) {
        inputValue();
    }

    private static void inputValue() {
        Random random = new Random();
        int randomValue = random.nextInt(11);

        for (int i = 0; i <= ATTEMPT_COUNT; i++) {
            if (i == ATTEMPT_COUNT) {
                System.out.println("GameOver!");
                System.out.println("Random value is " + randomValue + ".");
                break;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input a value: ");
            String str = scanner.nextLine();

            try {
                int value = Integer.parseInt(str);

                if (compareValue(value, randomValue, checkWin)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("It's not a value. " + e.getMessage());
            }
        }
    }

    private static boolean compareValue(int value, int randomValue, boolean checkWin) {
        if (value < randomValue) {
            System.out.println("The value is less.");
        } else if (value > randomValue) {
            System.out.println("The value is more.");
        } else {
            System.out.println("Bingo!");
            checkWin = true;
        }

        return checkWin;
    }
}
    
