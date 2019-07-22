import java.text.NumberFormat;
import java.util.Scanner;

/*-------------------------------------------------------------------------
// AUTHOR: F. Navabi
// FILENAME: Assignment5.java
// SPECIFICATION: this program checks the methods in class BankAccount by providing a menu and the user input
// FOR: CSE 110- homework #5 MWF 9:40-10:30
// TIME SPENT:3 hours
//----------------------------------------------------------------------*/
public class Assignment5
{
    public static void main(String[] args)
	{
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

		//Make a Scanner object to get the input
		Scanner scan = new Scanner(System.in);
		double enteredAmount1, enteredAmount2, enteredAmount=0;
		char command;
		boolean flag;
		String input;
		// print intro message
        System.out.println("Welcome to CS110 BANK");

        // Ask for id
        System.out.print("What is your bank id? ");
		String enteredID = scan.nextLine();

       // Ask user for initial deposit
        do
        {
            System.out.print("Initial deposit into Checking: ");
            enteredAmount1 = scan.nextDouble();

            // make sure they enter a positive number
            if ( enteredAmount1 <= 0 )
            {
                System.out.println("Invalid choice (number must be positive).");
            }

        } while ( enteredAmount1 <= 0 );

        do
		{
		     System.out.print("Initial deposit into Saving: ");
		     enteredAmount2 = scan.nextDouble();

		     // make sure they enter a positive number
		     if ( enteredAmount2 <= 0 )
		     {
		           System.out.println("Invalid choice (number must be positive).");
		     }

        } while ( enteredAmount2 <= 0 );

		//instantiate a BankAccount object
		BankAccount account1= new BankAccount(enteredID, enteredAmount1, enteredAmount2);

		// print the menu
        printMenu();
		do
		 {
           // ask a user to choose a command
		   System.out.println("\nPlease enter a command or type ?");
		   input = scan.next();
           command = input.charAt(0);

           switch (command)
            {
                 case 'a': // Ask user for amount to deposite
                            System.out.println("Amount to deposit: ");
                            enteredAmount = scan.nextDouble();
                            account1.deposit(enteredAmount);
                            System.out.println("You deposited " + fmt.format(enteredAmount) + " to Checking.");

			               //print a prompt after the deposit
                      break;
                 case 'b':
					        do
					        {
					          System.out.print("Amount to withdraw: ");
					          enteredAmount = scan.nextDouble();

					          // make sure amount is positive and less than current checking balance
					          if (enteredAmount <= 0)
					          		System.out.println("Invalid choice (number must be positive).");
					        } while (enteredAmount <= 0);

					       // update balance and display message
					       flag = account1.withdraw(enteredAmount);
					       if (flag)
					       			System.out.println("You withdrew " + fmt.format(enteredAmount));
					       	else
					       			System.out.println("Invalid choice (not sufficient fund)");

                      break;

                 case 'c': // print the info on each account
                 			System.out.println(account1.toString());

                      break;
                 case 'd': // ask for customer is and check if is the correct id
					       // Ask for id
						   System.out.print("What is your bank id? ");
						   enteredID = scan.next();

						   if (account1.equals(enteredID))
						   		System.out.println("Here is the balance: " + account1.toString());
						   	else
						   		System.out.println("Wrong ID!");

                      break;
                 case '?': // display the menu again
                             printMenu();
                             break;
                 case 'q':// add the interest based on type of account and quit the program
                 			account1.addInterest();
                 			System.out.println(account1.toString());
                      break;
				 default:
					  System.out.println("Invalid choice!");
					  break;


            }

        } while (command != 'q');
	} // end of main

   // this method prints out the menu to a user
   public static void printMenu()
   {
    System.out.print("\nCommand Options\n"
                   + "-----------------------------------\n"
                   + "a: deposit\n"
                   + "b: withdraw\n"
                   + "c: display the balance \n"
                   + "d: Check the account\n"
                   + "?: display the menu again\n"
                   + "q: quit this program\n\n");
    }

}  // end class