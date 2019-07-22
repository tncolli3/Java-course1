//**********************************************************************
// Name: Taylor Collins
// Title: Assignment4.java
// Description: A more efficient way to create and manage a bank account
// Time spent: 3 hours
// Date: 9/21/17
//**********************************************************************
//a.
//	i is: 0
//	i is: 1
//	i is: 2
//	i is: 3
//	i is: 4
//b. 56 times
//c. while(x<0 || x>100){
//		System.out.print(Number is not within range. Please enter another: ");
//		x=scan.nextInt();
//	 }
//***********************************************************************


import java.util.*;
import java.text.NumberFormat;
public class Assignment4
{
	public static void main(String[]args)
	{
		double SavingsDeposit;
		double CheckingDeposit;
		double SecondDeposit;
		double Withdraw=0;
		double Transfer;
		double TotalBalance;
		String CustomerName;
		int BankChoice;
		int Choice;
		final double BASIC_INTEREST=0.025;
		final double PREMIUM_INTEREST=0.035;
		final double PLATINUM_INTEREST=0.045;
		Scanner scan=new Scanner(System.in);
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		System.out.println("Welcome to CSE110 Bank");
		System.out.print("What is your name? ");
		CustomerName=scan.nextLine();
		System.out.print("Intial deposit into savings: ");
		SavingsDeposit=scan.nextDouble();


		while(SavingsDeposit<0)				//Checks to make sure the entered amount is positive
		{
			System.out.println("Invalid Choice. Savings must be positive");
			System.out.println("Intial deposit into savings: ");
			SavingsDeposit=scan.nextDouble();
		}
		System.out.print("Intial deposit into Checking: ");
		CheckingDeposit=scan.nextDouble();
		while(CheckingDeposit<0)
		{
			System.out.println("Invalid Choice. Checking must be positive");
			System.out.println("Intial deposit into checking: ");
			CheckingDeposit=scan.nextDouble();
		}


		TotalBalance=SavingsDeposit+CheckingDeposit;
		if(TotalBalance>0 && TotalBalance<1000)					//determines type of account
		{
			System.out.println(CustomerName + "'s Basic Account Balance: "  + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
		}
		else if(TotalBalance>=1000 && TotalBalance<=5000)
		{
			System.out.println(CustomerName + "'s Premium Account Balance: "  + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
		}
		else if(TotalBalance>5000)
		{
			System.out.println(CustomerName + "'s Platinum Account Balance: "  + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
		}



		System.out.println("Bank options");
		System.out.println("1. Deposit Money");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Transfer Money");
		System.out.println("4. Quit");
		System.out.print("Your Choice: ");
		BankChoice=scan.nextInt();
		System.out.println("   ");
		while(BankChoice<=0 || BankChoice>4)
		{
			System.out.println("Invalid Choice(not an option).");
			System.out.print("Your Choice: ");
			BankChoice=scan.nextInt();
		}



		while(BankChoice!=4)
		{
			switch(BankChoice)
			{
				case 1:
				System.out.println("Deposit Money Options:");
				System.out.println("1. Deposit to Checking");
				System.out.println("2. Deposit to Savings");
				System.out.println("3. Quit");
				System.out.print("Your Choice: ");
				System.out.println("   ");
				break;
				case 2:
				System.out.println("Withdraw Money Options:");
				System.out.println("1. Withdraw from Checking");
				System.out.println("2. Withdraw from Savings");
				System.out.println("3. Quit");
				System.out.print("Your Choice: ");
				System.out.println("    ");
				break;
				case 3:
				System.out.println("Transfer Money Options:");
				System.out.println("1. Transfer to Checking from Savings");
				System.out.println("2. Transfer to Savings from Checking");
				System.out.println("3. Quit");
				System.out.print("Your Choice: ");
				System.out.println("    ");
				break;
			}
			Choice=scan.nextInt();
			while(Choice<=0 || Choice>3)
			{
				System.out.println("Invalid Choice(not an option.)");
				System.out.print("Your Choice: ");
				Choice=scan.nextInt();
			}



			switch(Choice)
			{
				case 1:
				if(BankChoice==1)
				{
					System.out.print("Amount to Deposit to Checking: ");
					SecondDeposit=scan.nextDouble();
					while(SecondDeposit<0)
					{
						System.out.println("Invalid choice(number must be positive)");
						System.out.print("Amount to deposit to Checking: ");
						SecondDeposit=scan.nextDouble();
					}
					System.out.println("You deposited " + fmt.format(SecondDeposit) +" to checking");
					CheckingDeposit=CheckingDeposit+SecondDeposit;
					TotalBalance=CheckingDeposit+SavingsDeposit;

				}
				if(BankChoice==2)
				{
					System.out.print("Amount to withdraw from Checking: ");
					Withdraw=scan.nextDouble();

					while(Withdraw>CheckingDeposit)
					{
						System.out.println("Invalid Choice. insufficient funds");
						System.out.print("Amount to withdraw from Checking: ");
						Withdraw=scan.nextDouble();
					}
					while(Withdraw<0.0)
					{
						System.out.println("Invalid choice(number must be positive)");
						System.out.print("Amount to withdraw from Checking: ");
						Withdraw=scan.nextDouble();
					}
					System.out.println("You withdrew " +fmt.format(Withdraw)+ " from Checking");
					CheckingDeposit=CheckingDeposit-Withdraw;
					TotalBalance=CheckingDeposit+SavingsDeposit;
				}
				if(BankChoice==3)
				{
					System.out.print("Amount to transfer to checking: ");
					Transfer=scan.nextDouble();
					while(Transfer<0.0)
					{
						System.out.println("Invalid choice(number must be positive)");
						System.out.print("Amount to transfer to checking: ");
						Transfer=scan.nextDouble();
					}
					while(Transfer>SavingsDeposit)
					{
						System.out.println("Invalid choice. (Insufficient funds)");
						System.out.print("Amount to transfer to checking: ");
						Transfer=scan.nextDouble();
					}
					System.out.println("You transferred " + fmt.format(Transfer)+ " to checking");
					CheckingDeposit=CheckingDeposit+Transfer;
					SavingsDeposit=SavingsDeposit-Transfer;
					TotalBalance=CheckingDeposit+SavingsDeposit;
				}
				break;



				case 2:
				if(BankChoice==1)
				{
					System.out.print("Amount to Deposit to Savings: ");
					SecondDeposit=scan.nextDouble();
					while(SecondDeposit<0)
					{
						System.out.println("Invalid choice(number must be positive)");
						System.out.print("Amount to deposit to Savings: ");
						SecondDeposit=scan.nextDouble();
					}
					System.out.println("You deposited " + fmt.format(SecondDeposit) +" to Savings");
					SavingsDeposit=SavingsDeposit+SecondDeposit;
					TotalBalance=CheckingDeposit+SavingsDeposit;
				}
				if(BankChoice==2)
				{
					System.out.print("Amount to withdraw from Savings: ");
					Withdraw=scan.nextDouble();
					while(Withdraw>SavingsDeposit)
					{
						System.out.println("Invalid Choice. insufficient funds");
						System.out.print("Amount to withdraw from Savings: ");
						Withdraw=scan.nextDouble();
					}
					if(Withdraw<0)
					{
						System.out.println("Invalid choice(number must be positive)");
						System.out.print("Amount to withdraw from Savings: ");
						Withdraw=scan.nextDouble();
					}
					System.out.println("You withdrew " +fmt.format(Withdraw)+ " from Savings");
					SavingsDeposit=SavingsDeposit-Withdraw;
					TotalBalance=CheckingDeposit+SavingsDeposit;

				}
				if(BankChoice==3)
				{
					System.out.print("Amount to transfer to Savings ");
					Transfer=scan.nextDouble();
					while(Transfer<0)
					{
						System.out.println("Invalid choice(number must be positive)");
						System.out.print("Amount to transfer to Savings");
						Transfer=scan.nextDouble();
					}
					while(Transfer>CheckingDeposit)
					{
						System.out.println("Invalid choice. (Insufficient funds)");
						System.out.print("Amount to transfer to Savings: ");
						Transfer=scan.nextDouble();
					}
					System.out.println("You transferred " + fmt.format(Transfer)+ " to Savings");
					SavingsDeposit=SavingsDeposit+Transfer;
					CheckingDeposit=CheckingDeposit-Transfer;
					TotalBalance=CheckingDeposit+SavingsDeposit;
				}
				break;
			}
			System.out.println("Bank options");
			System.out.println("1. Deposit Money");
			System.out.println("2. Withdraw Money");
			System.out.println("3. Transfer Money");
			System.out.println("4. Quit");
			System.out.print("Your Choice: ");
			BankChoice=scan.nextInt();
			while(BankChoice<0 || BankChoice>4)
			{
				System.out.println("Invalid Choice(not an option).");
				System.out.print("Your Choice: ");
				BankChoice=scan.nextInt();
			}


		}
		if(BankChoice==4)
		{
			System.out.println("Thank you for using CSE110 Bank. Goodbye!");
		}
		TotalBalance=CheckingDeposit+SavingsDeposit;
		System.out.println("After this transaction your balance is: " + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
		System.out.println("    ");

		System.out.println("We have added interest to your account!");
		if(TotalBalance>0 && TotalBalance<1000)
		{
			System.out.println(CustomerName+"'s  Basic account Balance is: (S: " +(fmt.format((SavingsDeposit*BASIC_INTEREST)+SavingsDeposit)) +",C: " + (fmt.format((CheckingDeposit*BASIC_INTEREST)+CheckingDeposit)) +")");
		}
		if(TotalBalance>=1000 && TotalBalance<=5000)
		{
			System.out.println(CustomerName+ "'s Premium account balance is: (S: " + (fmt.format((SavingsDeposit*PREMIUM_INTEREST) + SavingsDeposit)) + ",C: " + (fmt.format((CheckingDeposit*PREMIUM_INTEREST) + CheckingDeposit)) +")");
		}
		if(TotalBalance>5000)
		{
			System.out.println(CustomerName+ "'s Platinum account balance is: (S: " +(fmt.format((SavingsDeposit*PLATINUM_INTEREST)+SavingsDeposit)) + ",C: " + (fmt.format((CheckingDeposit*PLATINUM_INTEREST)+CheckingDeposit)) +")");
		}
	}
}


