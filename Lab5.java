/*-------------------------------------------------------------------------
// AUTHOR: Taylor Collins
// FILENAME: Lab5.java
// SPECIFICATION: a program does completes one of two requests
// FOR: CSE 110- Lab #5
// TIME SPENT: 10 minutes
//-----------------------------------------------------------*/


import java.util.Scanner;   //import scanner
public class Lab5			//declare class
{
	public static void main(String[]args)
	{
		int choice;					//initialize variables
		Scanner scan=new Scanner(System.in);
		do
		{
			System.out.println("PLease choice from the following menu"); // print menu
			System.out.println("1)Print through all integer numbers between two given integers");
			System.out.println("2)Display a pattern-right triangle of stars");
			System.out.println("3)Quit.");
			System.out.print("Your Choice: ");
			choice=scan.nextInt();

			switch(choice)			//delcare switch
			{
				case 1:
				int i;
				int start=0,end=0;
				System.out.print("Enter the start number: "); //ask user to input starting number
				start=scan.nextInt();
				System.out.print("Enter the end number: ");	  //ask user to input ending number
				end=scan.nextInt();

				System.out.println("   ");
				for(i=start;i<=end;i++)		//loop from start to end
				{
					System.out.print(i + "  ");
				}
				System.out.println("    ");
				System.out.println("    ");
					break;
				case 2:
				int height,j; //initialize height and j
				System.out.println("Enter the height:");	//ask for user to imput height
				height=scan.nextInt();
				for(i=1;i<=height;i++)
				{
					for(j=1;j<=i;j++) //nested loop
					{
						System.out.print("*");
					}
					System.out.print("\n");
				}
					break;
				case 3:
					break;
				default:	//default case doesn't do anything, but we define it just in case
					break;
			}
		}while(choice!=3);
	} //close main method
}  //close class