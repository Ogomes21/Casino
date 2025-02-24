package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.Casino;

import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessMain {
    private Casino casino;
    static boolean running = true;
    static int input;
    static NumberGuessEngine guessEngine = new NumberGuessEngine();
    static Scanner scanner = new Scanner(System.in);

//    public static void main(String[] args){
//        playGame();
//    }

    public void playGame() {
        casino = new Casino();

        guessEngine.prompt();
        //input = scanner.nextInt();
        guessEngine.getInput();
        if(input == 2) {
            running = false;
            casino.splashScreen();
        }
        while(running){
            int count = 0;
            int randomNum = guessEngine.randomNumber();
            guessEngine.promptForGuess();

            while(true){
                input = guessEngine.getInput();

                count++;
                if(randomNum == input) {
                    System.out.println("Congrats you won!!!");
                    break;
                } else if(count == 3){
                    System.out.println("You lose!");
                    break;
                } else if (randomNum > input){
                    System.out.println("Number is higher, try again");
                } else if (randomNum < input){
                    System.out.println("Number is lower, try again");
                }
            }

            guessEngine.promptContinue();
            input = scanner.nextInt();
            //guessEngine.getInput();
            if(input == 1){
                continue;
            } else if (input == 2) {
                running = false;
                casino.splashScreen();
            }
        }
    }
}