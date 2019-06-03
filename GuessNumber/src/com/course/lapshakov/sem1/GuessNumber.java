package com.course.lapshakov.sem1;

class GuessNumber {
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
}

