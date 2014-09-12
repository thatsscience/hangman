/*******************************************************
********************************************************
**                                                    **
**                Name: Nathan Ivy                    **
**             Date: September 4, 2014                **
**                                                    **
********************************************************
*******************************************************/

import  java.util.Random;
import  java.util.Scanner;

public class Hangman {
   static int numberOfLives = 6;
   static String[] wordBank = 
     {"ALASKA","ALABAMA", "ARIZONA", "ARKANSAS", "CALIFORNIA", 
      "COLORADO", "CONNECTICUT", "DELAWARE", "FLORIDA", 
      "GEORGIA", "HAWAII", "IDAHO", "ILLINOIS", "INDIANA", 
      "IOWA", "KANSAS", "KENTUCKY", "LOUISIANA", "MAINE", 
      "MARYLAND", "MASSACHUSETTS", "MICHIGAN", "MINNESOTA", 
      "MISSISSIPPI", "MISSOURI", "MONTANA", "NEBRASKA", 
      "NEVADA", "NEW HAMPSHIRE", "NEW JERSEY", "NEW MEXICO", 
      "NEW YORK", "NORTH CAROLINA", "NORTH DAKOTA", "OHIO", 
      "OKLAHOMA", "OREGON", "PENNSYLVANIA", "RHODE ISLAND", 
      "SOUTH CAROLINA", "SOUTH DAKOTA", "TENNESSEE", "TEXAS",
      "UTAH", "VERMONT", "VIRGINIA", "WASHINGTON",
      "WEST VIRGINIA", "WISCONSIN", "WYOMING"};  
      
   public static void main(String[] args) throws Exception {
      String secretWord = wordBank[new Random().nextInt(wordBank.length)], guesses = " ";
      int misses = -1;  

      System.out.println("Welcome to Hangman!");
      System.out.println("Total Number of Lives: " + numberOfLives);
      //I have changed this to a "for" loop  
      for(Scanner input = new Scanner(System.in); 
         !secretWord.matches("[" + guesses + "]+") & (misses += secretWord.contains(guesses.substring(0, 1)) ? 0 : 1) <= numberOfLives;
         guesses = input.nextLine().toUpperCase().charAt(0) + guesses){
            System.out.println(secretWord.replaceAll("(?<=.)", " ").replaceAll("[^" + guesses + "]", "-") + ("(Lives Left: " + (numberOfLives - misses) + ")"));
         }

        if(secretWord.matches("[" + guesses + "]+")){
            System.out.println();
   			System.out.println("GREAT JOB! The word was " + secretWord);
   			System.out.println("***********************************");
   			System.out.println("*                                 *");
   			System.out.println("*             YOU WIN             *");
   			System.out.println("*                                 *");
   			System.out.println("***********************************");
   		}
   		if(misses > numberOfLives){
            System.out.println();
   			System.out.println("You Lose! The word was " + secretWord);
   			System.out.println("***********************************");
   			System.out.println("*                                 *");
   			System.out.println("*            GAME OVER            *");
   			System.out.println("*                                 *");
   			System.out.println("***********************************");
   		} 
   }
}
