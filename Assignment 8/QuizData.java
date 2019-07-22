import java.util.*;
import java.io.*;
import java.text.*;
/*-------------------------------------------------------------------------
// AUTHOR: Taylor Collins
// FILENAME: QuizData.java
// SPECIFICATION: class containing methods used in Assignment8.java
// FOR: CSE 110- homework #8 MWF 9:40-10:30
// TIME SPENT: 1 hour
//----------------------------------------------------------------------*/
public class QuizData
{
	private String[][] quizArray=null; //declare 2D array
	double sum=0.0;
	DecimalFormat fmt = new DecimalFormat( "0.00" );//declare decimal format
	int numElements,rows,columns=0; //declare numbers for the rows, columns and number of elements
	double average,lowest,highest=0.0; //declare doubles for the average,highest and lowest
	String line,str="";


	public QuizData(String filename) throws IOException //constructor
	{
		filename="quiz.txt";
		FileReader fr=new FileReader(filename);//read from file
		Scanner scan=new Scanner(fr);
		line=scan.nextLine();
		rows=Integer.parseInt(line.substring(0,2));
		columns=Integer.parseInt(line.substring(3,4));
		quizArray=new String[rows][columns]; //instantiate array

		int k;
		for(int i=0;i<rows;i++)//fill the array
		{
			k=1;//tracks the index of the substring
			line=scan.nextLine();
			for(int j=0;j<columns;j++)//fills the array
			{
				if(j==2 || j==3) //accounts for the two columns where the numbers are 5 characters long instead of four(100.0)
				{
					numElements++; //tracks total number of elements
					quizArray[i][j]=line.substring(k-1,k+6);
				}
				else{
					numElements++;
					quizArray[i][j]=line.substring(k,k+5);
				}

				if(j==4){//accounts for the extra spaces and characters as a result of columns 2 and three
					k+=6;
				}
				else{//increments k to the next set of numbers
				k+=7;
				}
			}
		}
	}

	public double quizAverage()//finds the average with the lowest quiz grade included
	{//quiz average
		for(int i=0;i<rows;i++)//adds together the elements of the array
		{
			for(int j=0;j<columns;j++)
			{
				sum+=Double.parseDouble(quizArray[i][j]);
			}
		}
		average=sum/numElements;//finds the average
		return average;
	}


	public String studentStatistics()//finds the average score for the student(without the lowest)
	{
		str="";
		System.out.println("Student     Average"+"\n ======      ======");//prints header
		for(int i=0;i<rows;i++)//searches for the lowest grade and adds the elements together
		{
			sum=0.0;
			str+="\n"+"   "+(i+1)+"         ";
			lowest=Double.parseDouble(quizArray[i][columns-1]);
			for(int j=0;j<columns;j++)
			{
				sum+=Double.parseDouble(quizArray[i][j]);
				if(Double.parseDouble(quizArray[i][j])<lowest)
				{
					lowest=Double.parseDouble(quizArray[i][j]);
				}
			}
			str+=fmt.format((sum-lowest)/columns);//the average score,not including the lowest grade
		}
		return str;
	}

	public String quizStatistics()//finds information about each quiz
	{
		System.out.println("  Quiz  High    Low    Average"+ "\n  ====  =====   =====    ======");//prints header
		str="";

		for(int i=0;i<columns;i++)//finds lowest and highest quiz grades for each quiz
		{
			highest=Double.parseDouble(quizArray[10][i]);
			lowest=Double.parseDouble(quizArray[0][i]);
			str+="\n    "+(i+1)+"    ";
			sum=0.0;
			for(int j=0;j<rows;j++)
			{
				sum+=Double.parseDouble(quizArray[j][i]); //adds up the elements in the array
				if(Double.parseDouble(quizArray[j][i])<lowest) //finds the lowest element in the columns
				{
					lowest=Double.parseDouble(quizArray[j][i]);
				}
				if(Double.parseDouble(quizArray[j][i])>highest)//finds the highest element in the column
				{
					highest=Double.parseDouble(quizArray[j][i]);
				}
			}
			average=sum/rows;//finds the average score
			str+=highest+"    "+lowest+"     "+fmt.format(average); //puts the highest lowest and average in a string
		}
		return str;
	}




	public String toString()//prints out the array
	{//to string method
		String string="";
		for(int i=0;i<rows;i++)//concatinates the array elements with the string
		{
			string+="\n"+ i; //creates new line with the row(Student) number
			for(int j=0;j<columns;j++)
			{
				string+="   "+quizArray[i][j]+"  ";
			}
		}
		return string;// returns the string with the array elements
	}
}