/*-------------------------------------------------------------------------
// AUTHOR: Taylor Collins
// FILENAME: Lab11.java
// SPECIFICATION: create,fill,print and find the sum of a 2D array
// FOR: CSE 110- Lab #11
// TIME SPENT: 10 minutes
//----------------------------------------------------------------------*/


import java.util.*;
public class Lab11
{
	public static void main(String[]args)
	{
		int rows,columns,sum; //declare variables
		Scanner scan=new Scanner(System.in);

		System.out.println("Enter the number of rows in the array"); //prompt user for number of rows
		rows=scan.nextInt();
		System.out.println("Enter the number of columns in the array"); //prompt users for number of columns
		columns=scan.nextInt();

		int[][]intArray=new int[rows][columns]; //dec;are 2D array
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++) //fill the array
			{
				System.out.println("Please enter a value");
				intArray[i][j]=scan.nextInt();
			}
		}
		for(int i=0;i<rows;i++)//print out the array
		{
			System.out.println(); //starts new row for every i
			for(int j=0;j<columns;j++)
			{
				System.out.print(intArray[i][j]+" ");
			}
		}
		System.out.println();



		for(int i=0;i<rows;i++) //find the sum of the elements in the array
		{
			sum=0; //sum=0
			for(int j=0;j<columns;j++)
			{
				sum+=intArray[i][j];
			}
			System.out.println("Sum of row "+i+": "+sum); //prints sum
		}
	}
}