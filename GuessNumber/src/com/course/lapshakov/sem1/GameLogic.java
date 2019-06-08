package com.course.lapshakov.sem1;

class GameLogic {
    static boolean compareValue(int value, int randomValue) {
        boolean checkWin = false;

        if (value < randomValue) {
            System.out.println("Your value is less.");
        } else if (value > randomValue) {
            System.out.println("Your value is more.");
        } else {
            System.out.println("Bingo!");
            checkWin = true;
        }

        return checkWin;
    }

    static boolean checkGameOver(int counter, int randomValue) {
        boolean checkGameOver = false;

        if (counter == UserAction.ATTEMPT_COUNT) {
            System.out.println("GAME OVER!");
            System.out.println("Random value: " + randomValue);

            checkGameOver = true;
        }

        return checkGameOver;
    }
}

