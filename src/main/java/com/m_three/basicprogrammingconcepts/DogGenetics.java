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
public class DogGenetics {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your dog's name?");
        String dogName = sc.nextLine();
        System.out.println("Well then, I have this highly reliable report on "+ dogName+  " prestigious background right here.");
        System.out.println(dogName + " is: ");
        System.out.println("");
        String[] breeds = breedGen();
        int[] percent = percentageGen();
        for(int i = 0; i < 5 ; i++)
        {
            System.out.println(percent[i]+" % " +breeds[i]);
        }
        System.out.println("\n Wow, that's QUITE the dog! ");
    }
    
    
    public static String[] breedGen()
    {
        Random rand =  new Random();
        
        
        //to prevent duplicate breeds
        int[] usedIndex= {-1,-1,-1,-1,-1};
        int randIndex;
        //determine if dupe is found
        Boolean looking;

        //avalable breeds      
        String[] breeds = {"American Bully","Dingo","German Spitz", "Saint Bernard","Mucuchies", "Polish Tatra Sheepdog",
        "Hällefors Elkhound", "French Bulldog", "Dalmatian", "Blue Lacy"};
        //output breeds
        String[] currDogBreeds = new String[5];
       
        
        //loop through 5 indexs and find unique randomly generated values between 0->length-1 
        for(int i = 0; i < 5; i++)
        {
            looking =true;
            while(looking)
            {
                //random gen int in index
                randIndex = rand.nextInt(breeds.length);

                //search the used generated index and check the generated value is a dupe             
                
                for(int j =0 ; j <= i ; j++ )
                {
                    if(usedIndex[j] == randIndex)//if duplicate is found break out of the for loop and gen a new one
                    {
                        looking = true;
                        break;
                    }
                    else if(j == i)//if no duplicate found and we are at the last index put the number in
                    {
                       usedIndex[i] = randIndex;
                       looking = false;
                    }
                }
            }
        }
        //populate the currDogBreeds with unique values
        for(int i =0; i < 5; i++)
        {
            String breed = breeds[usedIndex[i]];
            currDogBreeds[i] = breed;
        }
        return currDogBreeds;
    }
    
    
    
    /*
    goal generate a percent and populate array
    idea to artificailly create thresholds
    ie:
    1st percent is out of 50
    2nd percent is out of 20
    3rd percent is out of 15
    4th percent is out of 12
    5th is 100 - (sum of all percents) worst case its 3 
    */
    public static int[] percentageGen()
    {
        //int[] percent = new int[5];
        Random rand = new Random();
        int total = 100;
        int thresholdOne=rand.nextInt(50)+1;
        int thresholdTwo=rand.nextInt(30)+1;
        int thresholdThree=rand.nextInt(15)+1;
        int thresholdFour=rand.nextInt(4)+1;
        int thresholdFive=total- (thresholdOne+thresholdTwo+thresholdThree+thresholdFour);
        int[] percent = {thresholdOne,thresholdTwo,thresholdThree,thresholdFour,thresholdFive};
        
        return percent;
    }
    
}
