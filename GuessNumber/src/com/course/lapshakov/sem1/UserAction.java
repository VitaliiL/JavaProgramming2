package com.course.lapshakov.sem1;

import java.util.Random;
import java.util.Scanner;

class UserAction {
    static final int ATTEMPT_COUNT = 4;

    void activateGame() {
        Random random = new Random();
        int randomValue = random.nextInt(11);

        for (int i = 0; i <= ATTEMPT_COUNT; i++) {
            if(GameLogic.checkGameOver(i, randomValue)){
                break;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input a value: ");
            String inputString = scanner.nextLine();

            try {
                int value = Integer.parseInt(inputString);

                if (GameLogic.compareValue(value, randomValue)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("It's not a value. " + e.getMessage());
            }
        }
    }
}
