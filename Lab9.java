/*-------------------------------------------------------------------------
// AUTHOR: Taylor Collins
// FILENAME: Lab9.java
// SPECIFICATION: creates and fills an array then prints the elements and sums them
// FOR: CSE 110- Lab #9
// TIME SPENT: 15 minutes
//-----------------------------------------------------------*/
import java.util.*;
public class Lab9
{
	public static void main(String[]args)
	{
		int size; //size of array
		int j=0;
		double currentE; //current element
		double sum=0; //sum of the elements
		Scanner scan=new Scanner(System.in); //scanner object

		System.out.println("How many elements in the array?");
		size=scan.nextInt(); //store the integer using the scanner object
		double[] doubleArray=new double[size]; //declare the array
		for(int i=0; i<size; i++) //fill the array
		{
			System.out.println("Please enter the next value.");
			currentE=scan.nextDouble();
			doubleArray[i]=currentE;
		}
		System.out.println();
		for( int i=doubleArray.length-1;i>=0;i--)//display the elements in reverse
		{
			j++; //keeps track of the number of times the array has been printed
			sum+=doubleArray[i];
			if(j==9)//starts a new line after 8 elements have been printed
			{
				j=1;//resets the counter
				System.out.println();
			}
			System.out.print(doubleArray[i]+ " ");
		}
		System.out.println();

		System.out.println("The sum of the array's elements is: " +sum);
	}
}