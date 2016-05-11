package com.yatzee.play.business;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ScoreCalculator {

	public int checkScore(int[] array) {
		// For Yatzee Game Score
		int totalScore = 0;
		// Variables for checking Yatzee pattern
		boolean isStraight = true, isYahtzee = false, isThreeOfaKind = false, isTwoPair = false, isOnePair = false,
				isFullHouse = false, isFourOfaKind = false;
		Object temp;
		Map map = new HashMap<Integer, Integer>();

		// Sorting the Array to calulate the Yatzee score
		Arrays.sort(array);

		for (int i = 0; i < array.length; i++) {
			// Check if the Yatzee is straight
			if ((i > 0) && isStraight) {
				if (array[i] != (array[i - 1] + 1)) {
					isStraight = false;
				}
			}
			// inserting the Count of each Dice value in Key value pair
			temp = map.get(array[i]);
			if (temp == null) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], (int) temp + 1);
			}
		} // end for loop

		Iterator iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry mEntry = (Map.Entry) iterator.next();
			if ((int) mEntry.getValue() == 2) {
				if ((int) mEntry.getKey() == 4) {
					return 8;
				} else if (isOnePair) {
					isOnePair=false;
					isTwoPair = true;
				} else if (isThreeOfaKind) {
//					System.out.println("This is a Full house !");
					isFullHouse = true;
				} else {
					isOnePair = true;
				}
				totalScore = totalScore + ((int) mEntry.getKey()) * 2;
			} else if ((int) mEntry.getValue() == 3) {
				if (isOnePair) {
//					System.out.println("The is a Full House !");
					isFullHouse = true;
				} else {
					//System.out.println("This is Three of a Kind !");
					isThreeOfaKind = true;
				}
				totalScore = totalScore + ((int) mEntry.getKey()) * 3;
			} else if ((int) mEntry.getValue() == 4) {
		//		System.out.println("This is Four of a Kind !");
				isFourOfaKind = true;
				totalScore = totalScore + ((int) mEntry.getKey()) * 4;
			} else if ((int) mEntry.getValue() == 5) {
			//	System.out.println("This is a Yatzee !");
				isYahtzee = true;
				totalScore = 50;
				break;
			}

		} // end While loop

		
		if (isStraight) {
			if (array[0] == 1) {
				System.out.println("This is Low Straight !");
				return 15;
			} else {
				System.out.println("This is High Straight !");
				return 20;
			}
		}
		else if(isFullHouse){
			System.out.println("This is full house");
		}else if(isThreeOfaKind){
			System.out.println("This is three of a kind");
		}else if(isTwoPair)
		{
			System.out.println("This is two Pair !");
		}else if (isOnePair)
		{
			System.out.println("This is One Pair !");
		}else if(isYahtzee){
			System.out.println("This is yahtzee");
		}else if(isFourOfaKind){
			System.out.println("This is four of a kind");
		}
		
		return totalScore;
	}

}
