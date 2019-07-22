/*------------------------------------------------------
// Author: Taylor Collins
//FILENAME: Lab2.java
//Specification:Capitalizing and finding the length of an entered name
// For CSE110-Lab#2
//TIME SPENT: 20 minutes
//--------------------------------------*/
import java.util.Scanner;
public class Lab2
{
	public static void main(String[] args)
	{
		String firstname="";
		String lastname="";
		String fullname="";
		int namelength=0;
		Scanner scan=new Scanner(System.in);

		System.out.println("Please enter first name: ");
		firstname=scan.nextLine();
		System.out.println("Please enter last name: ");
		lastname=scan.nextLine();

		fullname=firstname + " " + lastname;
		fullname= fullname.toUpperCase();
		namelength= fullname.length();
		System.out.println( "Full name(in capitals): " + fullname);
		System.out.println( "Name length: " + namelength);

		String title1=new String("cse110");
		String title2="cse110";

		if(title1== title2)
		{
			System.out.println("String comparison using == method works");
		}
		else
		{
			System.out.println("System comparison using == method does NOT work");
		}

		if(title1.equals(title2))
		{
			System.out.println("String comparison using equals method works");
		}
		else
		{
			System.out.println("String comparison using equals method does NOT work");
		}
	}
}


