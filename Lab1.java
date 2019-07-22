//************************************************************
//Author: Taylor Collins
//Filename: Lab1
// Finds the average value of three tests grades
//For: CSE110-Lab #1
//Time Spent: 26 minutes
//************************************************************
import java.util.Scanner;
public class Lab1
{
	public static void main(String[] args)
	{
		int test1,test2,test3;
		double NUM_TESTS=3.0;
		double average;
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the score on the first test: ");
		test1= in.nextInt();
		System.out.print("Enter the score of the second test: ");
		test2= in.nextInt();
		System.out.print("Enter the score of the third test: ");
		test3= in.nextInt();
		average=(test1+test2+test3)/NUM_TESTS;
		System.out.println("Your average is: " + average);
	}
}

