package com.bridgelabs.GamblerProblem;

import java.util.Date;

public class GamblingProblem {

    static int DAILY_STAKE = 100;
    static int PER_DAY_BET = 1;
    static int win = 1;

    
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulator");
        for (int day =1; day<=20;day++) {
            DAILY_STAKE=100;
            while (DAILY_STAKE < 150 && DAILY_STAKE > 50) {
                int result = (int) (Math.random() * 10) % 2;
                if (result == win) {
                    DAILY_STAKE++;

                } else {
                    DAILY_STAKE--;
                }
            }
        }
        System.out.println("Total money left after 20 days is: " +DAILY_STAKE);

    }
}
