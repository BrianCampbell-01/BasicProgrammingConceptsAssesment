/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m_three.basicprogrammingconcepts;

import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class HealthyHearts {
    public static void main(String[] args)
    {
        int age = validateInput();
        int maxHeartRate = 220-age;
        double minHrZone= (maxHeartRate *.5) ,maxHrZone = (maxHeartRate*.85) ;
        System.out.println("Your maximum heart rate should be "+ maxHeartRate+ "beats per minute");
        System.out.println("Your target HR Zone is " + findIntValue(minHrZone)+" - " + findIntValue(maxHrZone)+" beats per minute");
        
    }
          
    //only accepts ints over 0
    public static int validateInput()
    {
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("What is your age?");
        do
        {
            try{
                input = Integer.parseInt(sc.nextLine());
                if(input < 1)
                {
                    throw new NumberFormatException();
                }
                break;
            }catch(NumberFormatException e){
                System.out.println("enter a valid age");
            }
        }while(true);
        return input;
    }   
    
  /*
    number becomes truncated when multipling by a double this ensures we get the 
    ceiling of each number ie:
    age= 50
    min = 85 , 145 max
    */
    static public int findIntValue(double value)
    {
        if(value - (int)value > 0)
            return (int)value+1;
        return (int)value;
    }
            
        
}
