/*-------------------------------------------------------------------------
// AUTHOR: Taylor Collins
// FILENAME: Assignment2.java
// SPECIFICATION: Puts three names in alphabetical order
// E  Mesut Erhan
// FOR: CSE 110- homework #2 - MWF 9:40-10:30
// TIME SPENT: 3 hours
//----------------------------------------------------------------------*/
// Question#1 System.out.println(mystring.length());
// Question#2 System.out.println(mystring.indexOf("d"));
// Question#3 System.out.println(mystring.substring(9,12))
// Question#4 a)True b)False c) True d)True
// Question#5 Hy
//----------------------------------------------------------------------*/

import java.util.*;
public class Assignment2
{
	public static void main(String[]args)
	{
		String firstname="";
		String secondname="";
		String thirdname="";
		Scanner scan=new Scanner(System.in);



		System.out.println("Please enter the first name: ");
		firstname=scan.nextLine();                                 //This section allows a user to imput the first name
		String Firstname= firstname.substring(0,1).toUpperCase() + firstname.substring(1).toLowerCase(); //makes the first letter capital and makes the rest lowercase

		if(Character.isDigit(firstname.charAt(0)))                //checks to make sure the name starts with a letter,then prints the appropriate response
		{
			System.out.println("Error: the first name was not accepted");
		}
		else
		{
			System.out.println(Firstname + " is the first name");
		}




		System.out.println("Please enter the second name: ");
		secondname=scan.nextLine();
		String Secondname= secondname.substring(0,1).toUpperCase() + secondname.substring(1).toLowerCase();

		if(Character.isDigit(secondname.charAt(0)))
		{
			System.out.println("Error: The second name was not accepted");
		}
		else
		{
		System.out.println(Secondname + " is the second name");
		}



		System.out.println("Please enter the third name: ");
		thirdname=scan.nextLine();
		String Thirdname= thirdname.substring(0,1).toUpperCase() + thirdname.substring(1).toLowerCase();

		if(Character.isDigit(thirdname.charAt(0)))
		{
			System.out.println("Error: The third name was not accepted");
		}
		else
		{
		System.out.println(Thirdname + " is the third name");
		}





		String Temp;
		if(Firstname.compareTo(Secondname)>0)
		{
			Temp=Firstname;
			Firstname=Secondname;
			Secondname=Temp;
		}
		if(Firstname.compareTo(Thirdname)>0)                     //this section compares the names to alphabetize them
		{
			Temp=Firstname;
			Firstname=Thirdname;
			Thirdname=Temp;
		}
		if(Secondname.compareTo(Thirdname)>0)
		{
			Temp=Secondname;
			Secondname=Thirdname;
			Thirdname=Temp;
		}




		System.out.println("The names in alphabetical order are");
		if(Character.isDigit(Firstname.charAt(0)))
		{

		}
		else
		{
		System.out.println("\"" + Firstname + "\"");
		}
															// this section checks each name to make sure a invalid name is not printed

		if(Character.isDigit(Secondname.charAt(0)))
		{

		}
		else
		{
		System.out.println("\"" + Secondname + "\"");
		}


		if(Character.isDigit(Thirdname.charAt(0)))
		{

		}
		else
		{
		System.out.println("\"" + Thirdname + "\"");
		}

	}
}
