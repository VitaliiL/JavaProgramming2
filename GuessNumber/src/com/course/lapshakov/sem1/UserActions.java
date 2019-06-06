package com.course.lapshakov.sem1;

import java.util.Random;
import java.util.Scanner;

class UserActions {
    static final int ATTEMPT_COUNT = 4;

    void inputValue() {
        Random random = new Random();
        int randomValue = random.nextInt(11);

        for (int i = 0; i <= ATTEMPT_COUNT; i++) {
            if(GuessNumber.checkGameOver(i, randomValue)){
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
