package com.course.lapshakov.sem1;

import java.util.Random;
import java.util.Scanner;

class UserActions {
    private static final int ATTEMPT_COUNT = 8;
    private static final String GAME_OVER = "GameOver!";
    private static final String RANDOM_VALUE = "Random value: ";

    void inputValue() {
        Random random = new Random();
        int randomValue = random.nextInt(11);

        for (int i = 0; i <= ATTEMPT_COUNT; i++) {
            if (i == ATTEMPT_COUNT) {
                System.out.println(GAME_OVER);
                System.out.println(RANDOM_VALUE + randomValue);
                break;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input a value: ");
            String str = scanner.nextLine();

            try {
                int value = Integer.parseInt(str);

                if (GuessNumber.compareValue(value, randomValue)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("It's not a value. " + e.getMessage());
            }
        }
    }
}
