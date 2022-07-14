package com.bridgelabs.GamblerProblem;
import java.util.Scanner;

public class GamblingProblem {

    static final int STAKE = 100;
    static int PER_DAY_BET = 1;
    static int win = 1;
    static int daysWon=0;
    static int daysLost=0;
    static int totalAmountWon=0;
    static int totalAmountLost=0;
    static int DAYS_IN_MONTH =20;
    static int dailyStake;
    static int MAX_WIN_PER_DAY=150;
    static int MAX_LOSS_PER_DAY=50;
    static int wonMax=0;
    static int lostMax=0;
    static int luckyDay;
    static int unluckyDay;
    static int month =1;


    public static void game(){
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
                totalAmountWon+=50;

                if (dailyStake > wonMax) {
                    wonMax = dailyStake;
                    luckyDay = day;
                }

                System.out.println("Won on day "+day + " is "+ (dailyStake-STAKE));
                daysWon++;
            }
            else {
                totalAmountLost-=50;
                if (dailyStake > lostMax) {
                    lostMax = dailyStake;
                    unluckyDay = day;
                }
                System.out.println("Lost on day "+day +" is "+ (STAKE-dailyStake));
                daysLost++;
            }
        }
    }
    static void continueGame(){
        while(true) {
            System.out.println("Total amount won in  is "+ totalAmountWon);
            System.out.println("Total amount lost in  is "+ totalAmountLost);
            System.out.println("No of days won is: "+ daysWon);
            System.out.println("No of days Lost is: "+ daysLost);
            System.out.println("luckiest day is day " +luckyDay);
            System.out.println("Unlukiest day is day " +unluckyDay);
            int totalProfitLoss = totalAmountWon + totalAmountLost;
            System.out.println("Total Profit or loss in month "+month +" is "+ totalProfitLoss);
            month++;
            if (totalProfitLoss >= 100) {
                System.out.println("Eligible to continue for next month");
                System.out.println("Do you want to continue(Y/y)");
                Scanner scr = new Scanner(System.in);
                char option = scr.next().charAt(0);
                if (option == 'y' || option == 'Y') {
                    game();
                }
                else{
                    break;
                }
            } else {
                System.out.println("You are in Loss!!!Not Eligible to continue");
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulator");
        game();
        continueGame();
    }
}
