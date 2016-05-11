package com.yatzee.play.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yatzee.play.business.ScoreCalculator;

public class YatzeeTest {

	/*
	 * Valid Test Cases
	 */
	int[] input1 = { 1, 2, 3, 4, 5 };
	int[] input2 = { 1, 1, 3, 4, 5 };
	int[] input3 = { 1, 1, 1, 4, 5 };
	int[] input4 = { 1, 1, 1, 1, 5 };
	int[] input5 = { 1, 1, 1, 1, 1 };
	int[] input6 = { 1, 1, 1, 5, 5 };
	int[] input7 = { 2, 3, 4, 5, 6 };
	int[] input8 = { 2, 2, 5, 5, 1 };

	ScoreCalculator scoreCalculator = new ScoreCalculator();

	@Test
	public void testValidate() {
		System.out.println("Following are the Test results...");
		 
		assertEquals(15, scoreCalculator.checkScore(input1));
		System.out.println("--------------------------------");
		assertEquals(2, scoreCalculator.checkScore(input2));
		System.out.println("--------------------------------");
		assertEquals(3, scoreCalculator.checkScore(input3));
		System.out.println("--------------------------------");
		assertEquals(4, scoreCalculator.checkScore(input4));
		System.out.println("--------------------------------");
		assertEquals(50, scoreCalculator.checkScore(input5));
		System.out.println("--------------------------------");
		assertEquals(13, scoreCalculator.checkScore(input6));
		System.out.println("--------------------------------");
		assertEquals(20, scoreCalculator.checkScore(input7));
		System.out.println("--------------------------------");
		assertEquals(18, scoreCalculator.checkScore(input8));

	}

}
