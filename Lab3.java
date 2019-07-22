/*-------------------------------------------------------------------------
// AUTHOR: Taylor Collins
// FILENAME: Lab3.java
// SPECIFICATION: determine if a student passed, based on their homework grade
// FOR: CSE 110- Lab #3
// TIME SPENT: 30 minutes
//-----------------------------------------------------------*/

import java.util.Scanner;
public class Lab3
{
	public static void main(String[] args)
	{
		double finalexamGrade=50.0;
		double midtermGrade= 50;
		double homeworkGrade=0.0;			//declaring variables
		double finalGrade=0.0;
		char letterGrade=' ';
		Scanner Scan=new Scanner(System.in);	//a variable type of scanner


		System.out.println("Enter student's homework grade: ");  //print a statement asking the user for
		homeworkGrade=Scan.nextDouble();						//Student's homework grade

		if(homeworkGrade<=100 && homeworkGrade>=0)
		{
			finalGrade=(finalexamGrade*.50)+(midtermGrade*.25)+(homeworkGrade*.25); // calculates student's grade

			if(finalGrade >=50)
			{
				letterGrade='P';
			}
			else if(finalGrade <50)					// finds grade letter
			{
				letterGrade='F';
			}
												//checks student's grade
			if(letterGrade=='P')				//tells if student passed
			{
				System.out.println("The Student has passed");
			}
			else if( letterGrade=='F')			//tells if student failed
			{
				System.out.println("The Student has failed");
			}
		}

		else
		{
			System.out.println("Invalid imput. Homework Grade must be between 0 and 100");
		}
	}
}