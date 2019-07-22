/*-------------------------------------------------------------------------
// AUTHOR: Taylor Collins
// FILENAME: Lab4.java
// SPECIFICATION: Calculate different mathematical problems
// FOR: CSE 110- Lab #4
// TIME SPENT: 20 minutes
//-----------------------------------------------------------*/

import java.util.*;					//	Import required packages
public class Lab4					//	Declare class (Lab4)
{
	public static void main(String[]args)	//	Declare the main method
	{										// Declare variables for the function.
		int choice;					//	Create an integer variable named choice.
		Scanner scan=new Scanner(System.in);	//	Create a Scanner object (you may need to import the class)
		do							//initialize do-while loop
		{
			System.out.println("Please choose your choice from the following menu");
			System.out.println("1)Calculate the sum of integers 1 to m.");
			System.out.println("2)Calculate the factorial of given number.");
			System.out.println("3)Find the first digit of a given number.");
			System.out.println("4)Quit.");

			System.out.print("Choice: ");
			choice=scan.nextInt();			// Use scanner to get user input

			switch(choice)
			{
				case 1:
				int m,sum=0;
				System.out.println("Enter a number:");
				m=scan.nextInt();
				int i=1;
				while(i<=m)
				{
					sum=sum+i;
					i++;
				}
				System.out.println("The sum of first " +m+" numbers is " +sum);
					break;
				case 2:
				int n,fact=1;
				int j=1;
				System.out.print("Enter a number: ");
				n=scan.nextInt();
				while(j<=n)
				{
					fact=fact*j;
					j++;
				}
				System.out.println("The factorial of " +n+ " is:" +fact);
					break;
				case 3:
				int num,rem=0;
				System.out.print("Enter a number: ");
				num=scan.nextInt();
				while(num!=0)
				{
					rem=num%10;
					num=num/10;
				}
				System.out.println("The first integer of given number from the left is: "+ rem);
					break;
				default:					// A default case that doesn't do anything, but we define it just in case
					break;
			}
		}
		while(choice!=4);

	}			//	Close the main method
}				//Close the Class
