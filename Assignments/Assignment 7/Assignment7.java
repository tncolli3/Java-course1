/*-------------------------------------------------------------------------
// AUTHOR: Cheng-Yu
// FILENAME: Assignment7.java
// SPECIFICATION: A test driver of IntegerList
// YOUR Lab Letter and Name of the TA for your Closed lab
// FOR: CSE 110- homework #- days and time of your class
// TIME SPENT: how long it took you to complete the assignment
//----------------------------------------------------------------------*/
// 1. a.char[] charArray=new char[26];
// b. int[] words=new int[10];
// c.char[] charArray={'computer Science'};
// d. double[] nums={3.5,35.1,32.0};
// 2. 3
//    4
//    5
//    6
//    7
// 3. public String[] concatinate(String[]a,numElements){
//       for(int i=0;i<numElements;i++){
			//String str+=a[i];
	   //}
		//return str;
	//}
//---------------------------------------------------------------------*/

import java.util.Scanner;

public class Assignment7{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        char userChoice;
        int newVal, index;
        IntegerList intList = null;

        printMenu();

        do {
            System.out.print("Please enter a command or type? ");
            input = scan.nextLine();
            if (input.length() != 0)
                userChoice = input.charAt(0);
            else
                userChoice = ' ';
            switch (userChoice) {
            case 'a':
                System.out.print("How big should the list be? ");
                intList = new IntegerList(scan.nextInt()); scan.nextLine();
                System.out.print("What is range of the values for each random draw? ");
                intList.randomize(scan.nextInt()); scan.nextLine();
                break;
            case 'b':
                System.out.println(intList.toString());
                break;
            case 'c':
                System.out.print("Enter the value to add to the list: ");
                newVal = scan.nextInt(); scan.nextLine();
                System.out.print("Enter the index where you want to add the value: ");
                index = scan.nextInt(); scan.nextLine();
                intList.addElement(newVal, index);
                break;
            case 'd':
                System.out.print("Enter the value to delete: ");
                intList.removeFirst(scan.nextInt()); scan.nextLine();
                break;
            case 'e':
                System.out.print("Range of values is: " + intList.range());
                break;
            case 'q':
                break;
            default:
                printMenu();
                break;
            }
            System.out.println();
        } while (userChoice != 'q');

        scan.close();
    }

    private static void printMenu() {
        System.out.println(
            "   Menu\n" +
            "   ---------------\n" +
            "a. Create a new list(** do this first!! **)\n" +
            "b. Print the list\n" +
            "c. Add and element to the list at specified index\n" +
            "d: Remove a value from the list\n" +
            "e. Find the range\n" +
            "q. Quit\n"
        );
    }
}