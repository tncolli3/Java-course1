
 /*-------------------------------------------------------------------------
// AUTHOR: Taylor Collins
// FILENAME: IntegerList.java
// SPECIFICATION: Contains the methods to be tested in Assignment7.java
// E Mesut Ehran
// FOR: CSE 110- homework #7 MWF 9:40-10:30
// TIME SPENT: 1 hour
//----------------------------------------------------------------------*/

import java.util.*;
public class IntegerList
{
	private int[] intList=null; //declare the array
	private int numElements=0; //set number of elements to zero
	public IntegerList(int size) //constructor create an integer with a specific size
	{
		intList=new int[size];
	}

	public void randomize(int num) //fills the array with random numbers
	{

		for(int i=0;i<intList.length;i++)
		{
			numElements++;
			intList[i]=(1+(int)(Math.random()*num)); //numbers must be between 1 and the number(included)
		}
	}


	public void addElement(int newVal,int index) //adds an elements to the array at the given index
	{
		numElements++;
		if(numElements>intList.length) //if the array is full it will double the size
		{
			increaseSize();
		}
		for(int i=intList.length-1;i>index;i--) //moves the numbers to the right after the new element is added
		{
			intList[i]=intList[i-1];
		}
		intList[index]=newVal;
	}

	private void increaseSize() //doubles the size of the array
		{
			int[] newList= Arrays.copyOf(intList,2*intList.length); //makes a new integer with a size double the original
			intList=newList; //sets the original array to the new array
		}

	public void removeFirst(int newVal) //removes an elemeny
	{
		boolean search=false;
		int index=0;
		while(index<numElements && !search)//starts at an index of zero
		{
			if(intList[index]==newVal) //makes search true if the numbers match
			{
				search=true;
			}
			else{ //moves to the next index
				index++;
			}
			if(search){ //moves the elements to the left once newVal is removed
				for(int i=index+1;i<numElements;i++){
					intList[i-1]=intList[i];
				}
				numElements--;
			}
		}
	}
	public int range()
	{
		int min=intList[intList.length-1];
		int max=intList[intList.length-1];
		int range=0;
		for(int i=0;i<numElements;i++) //searches for the smallest element
		{
			if(intList[i]<min)
			{
				min=intList[i];
			}
		}

		for(int i=0;i<intList.length-1;i++)//searches for the largest element
		{
			if(intList[i]>max)
			{
				max=intList[i];
			}
		}

		range=(max-min)+1; //computes the range
		return range;
	}

	public String toString()
	{
		String str="";
		int j=0;
		for(int i=0;i<numElements;i++)//prints out the array
		{
			j++; //keeps track of elements printed
			if(j==11)//after ten elements a new row is started
			{
				j=1;
				str+="\n"+intList[i]+ " ";
			}
			else{
			str+=intList[i]+" ";
			}

		}
		return str;
	}
}


