package com.yatzee.play.Roll;

import java.util.Random;
import java.util.Scanner;

import com.yatzee.play.business.ScoreCalculator;

public class RollDice {

	private int[] dice = new int[5];
	private Random random = new Random();
	private int rollCount = 0;

	// Method to roll all the dice
	public int[] startRolling() {
		System.out.println("Rolling all dice ......");
		rollCount++;
		for (int i = 0; i < dice.length; i++) {
			dice[i] = 1 + random.nextInt(6);
			System.out.println("Value of Dice" + (i + 1) + " is : " + dice[i]);
		}
		return dice;
	}

	// method to roll selected dice at a time
	public int[] startReRoll(int[] selDice) {
		System.out.println("Replaying the selected Dice");
		rollCount++;

		for (int i = 0; i < selDice.length; i++) {
			dice[selDice[i]] = 1 + random.nextInt(6);
		}
		for (int i = 0; i < dice.length; i++) {
			System.out.println("Value of Dice" + (i + 1) + " is : " + dice[i]);
		}

		return dice;
	}

	public void beginYatzee() {

		Scanner reader = new Scanner(System.in);
		ScoreCalculator scoreCalculator = new ScoreCalculator();

		System.out.println("Let Play !");
		System.out.println("First Roll......");
		int firstRoll[] = startRolling();

		while (rollCount < 3) {
			System.out.println("Do you want to Reroll again?");
			System.out.println("Press 1 to reRoll all dices");
			System.out.println("Press 2 to roll other Selected dices ");
			System.out.println("Press 3 to Calculate your Score");

			int selectedChoice = reader.nextInt();
			reader.nextLine();
			if (selectedChoice == 1) {
				rollCount=0;
				dice = startRolling();
			} else if (selectedChoice == 2) {
				System.out.println("Enter the dice Number to be replayed with spaces: ");
				String reRollDiceNumber = reader.nextLine();
				int length = (reRollDiceNumber.split(" ")).length;
				int[] array = new int[length];
				String[] str = reRollDiceNumber.split(" ");

				try {
					for (int i = 0; i < length; i++) {
						array[i] = Integer.parseInt(str[i]) - 1;
					}
					dice = startReRoll(array);

				} catch (Exception e) {
					System.out.println("Invalid indices");
					e.printStackTrace();
				}

			} else if (selectedChoice == 3) {

				// Calling the method to Calculate the Yatzee Score
				int scoreForYatezee = scoreCalculator.checkScore(dice);
				System.out.println(" Score for the Yatzee Game is ==> " + scoreForYatezee);
				break;
			}
		}

		if (rollCount>= 3) {
			System.out.println("You have reached the Limit to Roll upto Three times");
			System.out.println("Calculating your Score....");
			int scoreForYatezee = scoreCalculator.checkScore(dice);
			System.out.println(" Score for the Yatzee Game is ==> " + scoreForYatezee);
		}

	}
}