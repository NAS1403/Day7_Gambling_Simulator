package com.bridgelabs.GamblerProblem;

public class GamblingProblem {

    static int DAILY_STAKE = 100;
    static int PER_DAY_BET = 1;
    static int win = 1;
    static int daysWon=0;
    static int daysLost=0;
    static int totalAmountWonFor20Day=0;
    static int totalAmountLostFor20Day=0;


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
            if(DAILY_STAKE>100) {
                totalAmountWonFor20Day+=50;
                System.out.println("Won on day "+day + " is "+ (DAILY_STAKE-100));
                daysWon++;
            }
            else {
                totalAmountLostFor20Day-=50;
                System.out.println("Lost on day "+day +" is "+ (100-DAILY_STAKE));
                daysLost++;
            }

        }

        System.out.println("Total amount won in 20 days is "+ totalAmountWonFor20Day);
        System.out.println("Total amount lost in 20 days is "+ totalAmountLostFor20Day);
        System.out.println("No of days won is: "+ daysWon);
        System.out.println("No of days Lost is: "+ daysLost);

    }
}
