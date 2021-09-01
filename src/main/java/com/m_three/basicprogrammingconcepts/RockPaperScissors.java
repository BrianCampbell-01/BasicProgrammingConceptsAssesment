/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m_three.basicprogrammingconcepts;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Brian
 */


public class RockPaperScissors {
    public static void main(String[] args)
    {
        Boolean gameState =  true;
        
        
        while(gameState)
        {
            int numberOfGames = gamesToPlay();
            rules();
            //init scores and choice variables
            int userChoice,computerChoice,userScore=0,computerScore=0,draw=0;
            
            for(int i = 0; i < numberOfGames; i++)
            {
                
                userChoice = userValue();
                computerChoice = computerValue();
                
                displayChoices(userChoice, computerChoice);
                
                
                //logic 1->rock 2->paper ->3 scissors
                //can put logic in a method for cleaner code
                //case user-> rock comp->Scissors
                if(userChoice==1 && computerChoice ==3)
                {
                    userScore++;
                }
                //case of user->rock comp->paper
                else if(userChoice==1 && computerChoice ==2)
                {
                    computerScore++;
                }
                //user->paper comp->scissors
                else if(userChoice==2 && computerChoice ==3)
                {
                    computerScore++;
                }
                //user-> paper comp-> rock
                else if(userChoice==2 && computerChoice == 1)
                {
                    userScore++;
                }
                //user-> scissors comp->paper
                else if(userChoice == 3 && computerChoice ==2)
                {
                    userScore++;
                }
                //user->scissors comp-> rock
                else if(userChoice==3 && computerChoice ==1)
                {
                    computerScore++;
                }
                else
                {
                    draw++;
                }
                
                displayScore(userScore,computerScore,draw);
                System.out.println("");
                //after the last game display winner
                if(i == (numberOfGames-1))
                {
                    gameState=displayWinner(userScore,computerScore);
                }
            }            
        }      
    }
    
    //also checks for valuid user input ie: 1-10
    public static int gamesToPlay()
    {
        int games;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many games would you like to play");
        do{
        try{
            games= Integer.parseInt(sc.nextLine());
            if(games < 1 || games >10)
            {
                throw new NumberFormatException();
            }
            break;
        }catch(NumberFormatException e)
        {
            System.out.println("enter a valid number between 1-10");
        }
        }while(true);
        return games;
    }
    
    
    //checks for only valid user input ie: 1: rock 2:paper 3: scissors
    public static int userValue()
    {
        int userChoice;
        Scanner sc = new Scanner(System.in);
        System.out.println("1: rock  2: paper 3: scissors");
        System.out.println("Enter a value: ");
        do
        {
            try{
                userChoice = Integer.parseInt(sc.nextLine());
                break;
            }catch(NumberFormatException e)
            {
                
                System.out.println("try again. enter a value between 1-3");
            }
        }while(true);
            return userChoice;
    }
    
    //returns a random value 1-3 to be used against the player
    public static int computerValue()
    {
        Random rand = new Random();
        return (rand.nextInt(3)+1);
    }
    
    //displays rules
    public static void rules(){
        System.out.println("Rules of the game each game must be between 1-10 games");
        System.out.println("Each turn the user must choose rock paper or scissors ");
        //System.out.println("1: rock  2: paper 3: scissors");
    }
    
    //shows the player thier choice as well as the computers
    public static void displayChoices(int user, int comp)
    {
        System.out.println("user: "+numberToValue(user)+"  comp: "+ numberToValue(comp));
    }
    
    //turns 1-> string value  Rock 2-> string value Paper etc
    public static String numberToValue(int value)
    {
        String strValue;
        if(value == 1){
            strValue = "Rock";
        }else if(value ==2){
            strValue = "Paper";
        }
        else{
            strValue = "Scissors";
        }
        return strValue;
    }
    //after each hand show the scores
    public static void displayScore(int userWins, int compWins, int draws)
    {
        System.out.println("user wins: " + userWins + " ~ comp wins: "+ compWins + " ~ draws: "+draws);
    }
    
    
    //last function call display the victor and calls a boolean to see if the game should continue
    public static Boolean displayWinner(int userWins, int compWins)
    {
        Boolean replay = false;
        if(userWins > compWins)
        {
            System.out.println("Congrats you win!");
        }
        else if(userWins < compWins)
        {
            System.out.println("Sorry you lost");
        }
        else
        {
            System.out.println("It was a Draw!");
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to play again? enter 1 to continue");
        String playAgain = sc.nextLine();
        System.out.println(playAgain);
        if (playAgain.equals("1"))
        {
            replay = true;
        }
        return replay;
    }
}

