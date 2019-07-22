/*-------------------------------------------------------------------------
// AUTHOR: Taylor collins
// FILENAME: Lab10.java
// SPECIFICATION: performations various operations on a array
// FOR: CSE 110- Lab #10
// TIME SPENT: 15 minutes
//----------------------------------------------------------------------*/


import java.util.*;
public class Lab10
{
	public static void main(String[]args)
	{
		int arraySize;
		double exchangeE;
		Scanner scan=new Scanner(System.in);

		System.out.println("How many elements in the array?"); //request Array size from the user
		arraySize=scan.nextInt(); //store in array size
		double[] doubleArray=new double[arraySize]; //declare array

		for(int i=0;i<arraySize;i++) //fill the array
		{
			System.out.println("Please enter the next value");
			doubleArray[i]=scan.nextDouble();
		}

		for(int i=0;i<arraySize;i++) //chooses each element of the array
		{
			for(int j=i+1;j<arraySize;j++) //compares the elements
			{
				if(doubleArray[i]>doubleArray[j]) //exchanges the elements
				{
					exchangeE=doubleArray[i];
					doubleArray[i]=doubleArray[j];
					doubleArray[j]=exchangeE;
				}
			}
		}

		System.out.println("The array's elements after sorting: ");
		System.out.println();
		for(int k=0;k<arraySize;k++) //displays the array after sorting
		{
			System.out.print(doubleArray[k]+" ");
		}
		System.out.println();//newline character

		for(int i=0;i<doubleArray.length-1;i++) //remove the minimum
		{
			doubleArray[i]=doubleArray[i+1];
		}
		doubleArray[doubleArray.length-1]=0; //makes the last element 0
		System.out.println();
		System.out.println("The array's elements after left shift: ");
		for(int k=0;k<arraySize;k++) //prints the array
		{
			System.out.print(doubleArray[k]+" ");
		}
		System.out.println(); //newline chracter

		System.out.println("Enter the element to search in the array");
		double search_element=scan.nextDouble();
		int element_found_flag=0;
		for(int i=0;i<doubleArray.length-1;i++){ //searches for and removes a element
			if(doubleArray[i]==search_element){
				element_found_flag=1;
			}
			if(element_found_flag==1){
				doubleArray[i]=doubleArray[i+1];
			}
		}
		doubleArray[doubleArray.length-1]=0;

		for(int k=0;k<arraySize;k++) //prints elements of the array
		{
			System.out.print(doubleArray[k]+ ",");
		}
		System.out.println(); //newline chraracter
	}
}

