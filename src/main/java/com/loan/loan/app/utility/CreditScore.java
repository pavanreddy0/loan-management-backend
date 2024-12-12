package com.loan.loan.app.utility;

import java.util.Random;

public class CreditScore {
    public static Integer getScore(){
        Random random = new Random();
        int min = 500;
        int max = 900;

        // Generate a random number between 500 and 900 (inclusive)
        return random.nextInt(max - min + 1) + min;
    }
}
