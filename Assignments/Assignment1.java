//**********************************************************************
//Name: Taylor Collins
//Title: Assignment1.java
//Author: Taylor Collins
//Description: A BMI calculating program for any height and weight
//Time spent:30 minutes
//8/30/17
//**********************************************************************
//a) 2. prints out the square root of b
//b)81.0 prints out the value of a to the power of b
//c)3 prints out the value of a + (b/c) without the decimal
//d)4 prints out 1+a
//e)4 prints out a+1
//f)6 prints out a+1
//g)3 remainder of d and c
//h)3 prints d/c without decimal
//i)22 prints d + (a/d) + b
//j)1 prints out (d plus a) divided by (d plus b)
//**********************************************************************
import java.util.Scanner;
public class Assignment1
{
	public static void main (String[] args)
	{
		int feet, inches;
		double height;
		double weight;
		double BMI_VALUE=703;
		double INCHESINFOOT=12;
		double bmi;
		Scanner in= new Scanner(System.in);
		System.out.println("What is your height?");
		System.out.print("Feet: ");
		feet=in.nextInt();
		System.out.print("Inches: ");
		inches=in.nextInt();
		System.out.print("What is your weight?: ");
		weight=in.nextDouble();
		height= ((feet*INCHESINFOOT) + inches);
		bmi= weight*(BMI_VALUE/(Math.pow(height,2)));
		System.out.println("Your BMI is: " + bmi);
	}
}

