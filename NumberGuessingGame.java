package main;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberGuessingGame {
	private static final int MAX_LIFELINES=1;
	private static int lifelinesUsed=0;
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		do {
			playGame(scanner);
			System.out.print("Do you want to play again?(yes/no):");
		}while
			(scanner.next().equalsIgnoreCase("yes"));
		System.out.println("Thanks for playing!");
		scanner.close();
	}
	
	private static void playGame(Scanner scanner) {
		Set<Integer>guessedNumbers=new HashSet<>();
		int initialRange = 100; //you can adjust the range as needed
		int secretnumber=generateRandomNumber(initialRange);
		int incorrectGuesses=0;
		 
		System.out.println("Welcome to the Number Guessing Game!");
		System.out.println("Try to guess the secret number between 1 to " + initialRange);
		
		while(true) {
			System.out.print("Enter your guess:");
			int userGuess = scanner.nextInt();
			if(userGuess==0 && lifelinesUsed<MAX_LIFELINES) {
				useLifeline(secretnumber,initialRange);
				lifelinesUsed++;
			}
			else if(guessedNumbers.contains(userGuess)) {
				System.out.println("You've already guessed that number.Try again.");
			}
			else {
				guessedNumbers.add(userGuess);
				if(userGuess==secretnumber) {
					System.out.println("Congratulations! You guessed the correct number.");
					break;
				}
				else if(userGuess>secretnumber) {
					System.out.println("Too high.Try again.");
				}
				else {
					System.out.println("Too low.Try again.");
				}
				incorrectGuesses++;
				
				if(incorrectGuesses==2) {
					System.out.println("Do you need a lifeline?(yes/no):");
					String lifelineResponse=scanner.next();
					if(lifelineResponse.equalsIgnoreCase("yes")&&lifelinesUsed<MAX_LIFELINES) {
						useLifeline(secretnumber,initialRange);
						lifelinesUsed++;
					}
					//Reset incorrect guesses count 
					incorrectGuesses=0;
				}
			}
		}
	}
	
	private static void useLifeline(int secretNumber,int range) {
		String nearestRange=calculateNearestRange(secretNumber,range);
		System.out.println("Lifeline:The secret number is " + ((secretNumber%2==0)?"even.":"odd.") + "The nearest range is " + nearestRange + 
				 " This hint does not guarantee correctness.Try again.");
	}
	private static String calculateNearestRange(int secretNumber,int range) {
		//Calculate the nearest range to the secret number
		int upperBound=Math.min(range, secretNumber + 10);
		int lowerBound=Math.max(1,secretNumber - 10);
		return lowerBound +"-"+ upperBound;
	}
	
	private static int generateRandomNumber(int range) {
		Random random=new Random();
		return random.nextInt(range) +1;
	}
}
