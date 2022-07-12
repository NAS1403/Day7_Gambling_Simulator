package com.bridgelabs.GamblerProblem;

public class GamblingProblem {

    static int STAKE = 100;
    static int PER_DAY_BET = 1;
    static int win = 1;
    static int daysWon=0;
    static int daysLost=0;
    static int totalAmountWonFor20Day=0;
    static int totalAmountLostFor20Day=0;
    static int DAYS_IN_MONTH =20;
    static int dailyStake;
    static int MAX_WIN_PER_DAY=150;
    static int MAX_LOSS_PER_DAY=50;
    static int wonMax=0;
    static int lostMax=0;
    static int luckyDay;
    static int unluckyDay;



    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulator");
        for (int day =1; day<=DAYS_IN_MONTH;day++) {
            dailyStake=STAKE;
            while (dailyStake < MAX_WIN_PER_DAY && dailyStake > MAX_LOSS_PER_DAY) {
                int result = (int) (Math.random() * 10) % 2;
                if (result == win) {
                    dailyStake++;
                } else {
                    dailyStake--;
                }
            }
            if(dailyStake>STAKE) {
                totalAmountWonFor20Day+=50;

                if (dailyStake > wonMax) {
                    wonMax = dailyStake;
                    luckyDay = day;
                }

                System.out.println("Won on day "+day + " is "+ (dailyStake-STAKE));
                daysWon++;
            }
            else {
                totalAmountLostFor20Day-=50;
                if (dailyStake > lostMax) {
                    lostMax = dailyStake;
                    unluckyDay = day;
                }
                System.out.println("Lost on day "+day +" is "+ (STAKE-dailyStake));
                daysLost++;
            }

        }

        System.out.println("Total amount won in 20 days is "+ totalAmountWonFor20Day);
        System.out.println("Total amount lost in 20 days is "+ totalAmountLostFor20Day);
        System.out.println("No of days won is: "+ daysWon);
        System.out.println("No of days Lost is: "+ daysLost);
        System.out.println("luckiest day is day " +luckyDay);
        System.out.println("Unlukiest day is day " +unluckyDay);

    }
}
