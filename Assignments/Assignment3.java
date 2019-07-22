/*-------------------------------------------------------------------------
// AUTHOR: Taylor Collins
// FILENAME: Assignmanet3.java
// SPECIFICATION: A bank account creator and manager
// E Mesut Erhan
// FOR: CSE 110- homework #3 MWF 9:40-10:30
// TIME SPENT: 7 hours
//----------------------------------------------------------------------*/

import java.util.*;									//import useful packages
import java.text.NumberFormat;
public class Assignment3
{
	public static void main(String[] args)
	{											//intitialize variables
		double SavingsDeposit;
		double CheckingDeposit;
		double Withdrawal;
		double Transfer;
		double SecondDeposit;
		String CustomerName;
		int Choice;
		int DepositChoice;
		int WithdrawChoice;
		int TransferChoice;
		double TotalBalance;
		final double BASIC_INTEREST=0.025;
		final double PREMIUM_INTEREST=0.035;
		final double PLATINUM_INTEREST=0.045;
		Scanner scan=new Scanner(System.in);
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

																	//prompts user to enter information to create bank account
		System.out.println("Welcome to CSE110 Bank");
		System.out.print("What is your name? ");
		CustomerName=scan.nextLine();
		System.out.print("Initial deposit into savings: ");
		SavingsDeposit=scan.nextInt();
		System.out.print("Initial deposit into checking: ");
		CheckingDeposit=scan.nextInt();
		TotalBalance= SavingsDeposit + CheckingDeposit;
		System.out.println("     ");

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


		System.out.println("Bank options:");						//prints banking options
		System.out.println("1. Deposit Money");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Transfer Money");
		System.out.println("4. Quit");
		System.out.print("Your Choice: ");
		Choice=scan.nextInt();
		System.out.println("       ");

		if(Choice==1)											//deposit options
		{
			System.out.println("Deposit Money Options:");
			System.out.println("1. Deposit to Checking");
			System.out.println("2.Deposit to Savings");
			System.out.println("3. Cancel");
			System.out.print("Your Choice: ");
			DepositChoice=scan.nextInt();
			System.out.println("     ");
			switch (DepositChoice)							//intialize switch for the deposit options
			{
				case 1: DepositChoice= 1;
						break;
				case 2: DepositChoice=2;
						break;
				case 3: DepositChoice=3;
						break;
				default: break;
			}
				if(DepositChoice==1)
				{
					System.out.print("Amount to deposit into checking: ");
					SecondDeposit=scan.nextInt();
					System.out.println("You Deposited $" +SecondDeposit +" To Checking.");
					CheckingDeposit=CheckingDeposit + SecondDeposit;
					TotalBalance=CheckingDeposit+SavingsDeposit;
					System.out.println("After this transaction your balance is: "  + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
				}
				else if(DepositChoice==2)
				{
					System.out.print("Amount to deposit into Savings: ");
					SecondDeposit=scan.nextInt();
					System.out.println("You Deposited $" +SecondDeposit +" To Savings.");
					SavingsDeposit=SavingsDeposit+SecondDeposit;
					TotalBalance=SavingsDeposit+CheckingDeposit;
					System.out.println("After this transaction your balance is: " + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
				}
				else if(DepositChoice==3)
				{
					System.out.println("Deposit Cancelled");
					System.out.println("After this transaction your balance is: "  + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
				}
		}
		if(Choice==1)   //calculates interest base on the type of account after the transaction is complete
		{
			if(TotalBalance>0 && TotalBalance<1000)
			{
				System.out.println("We have added interest to your account! (S: " +(fmt.format((SavingsDeposit*BASIC_INTEREST)+SavingsDeposit)) +",C: " + (fmt.format((CheckingDeposit*BASIC_INTEREST)+CheckingDeposit)) +")");
			}
			else if(TotalBalance>=1000 && TotalBalance<=5000)
			{
				System.out.println("We have added interest to your account! (S: " + (fmt.format((SavingsDeposit*PREMIUM_INTEREST) + SavingsDeposit)) + ",C: " + (fmt.format((CheckingDeposit*PREMIUM_INTEREST) + CheckingDeposit)) +")");
			}
			else if(TotalBalance>5000)
			{
				System.out.println("We have added interest to your account! (S: " +(fmt.format((SavingsDeposit*PLATINUM_INTEREST)+SavingsDeposit)) + ",C: " + (fmt.format((CheckingDeposit*PLATINUM_INTEREST)+CheckingDeposit)) +")");
			}
		}


		if(Choice==2)						//withdraw options
		{
			System.out.println("Withdraw Money Options:");
			System.out.println("1. Withdraw from Checking");
			System.out.println("2.Withdraw from Savings");
			System.out.println("3. Cancel");
			System.out.print("Your Choice: ");
			WithdrawChoice=scan.nextInt();
			System.out.println("     ");
			switch (WithdrawChoice)
			{
					case 1: WithdrawChoice= 1;
							break;
					case 2: WithdrawChoice=2;
							break;
					case 3: WithdrawChoice=3;
							break;
					default: break;
			}
				if(WithdrawChoice==1)
				{
					System.out.print("Amount to withdraw from checking: ");
					Withdrawal=scan.nextInt();
					if(Withdrawal>CheckingDeposit)
					{
						System.out.println("Invalid Choice. You do not have that much in your Checking");
						System.out.println("After this transaction your balance is: " +fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
					}
					else
					{
					System.out.println("You withdrew $" +Withdrawal +" From Checking.");
					CheckingDeposit= CheckingDeposit - Withdrawal;
					TotalBalance=CheckingDeposit+SavingsDeposit;
					System.out.println("After this transaction your balance is: " + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
					}
				}
				else if(WithdrawChoice==2)
				{
					System.out.print("Amount to withdraw into Savings: ");
					Withdrawal=scan.nextInt();
					if(Withdrawal>SavingsDeposit)
					{
						System.out.println("Invalid Choice. You do not have that much in your Savings");
						System.out.println("After this transaction your balance is: "  + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
					}
					else
					{
					System.out.println("You withdrew $" +Withdrawal +" from Savings.");
					SavingsDeposit=SavingsDeposit-Withdrawal;
					TotalBalance=CheckingDeposit+SavingsDeposit;
					System.out.println("After this transaction your balance is: " + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
					}
				}
				else if(WithdrawChoice==3)
				{
					System.out.println("Withdrawal Cancelled");
					System.out.println("After this transaction your balance is: " +fmt.format(TotalBalance)+"(S:" +fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
				}
		}
		if(Choice==2)
		{
		if(TotalBalance>0 && TotalBalance<1000)
				{
					System.out.println("We have added interest to your account! (S: " +(fmt.format((SavingsDeposit*BASIC_INTEREST)+SavingsDeposit)) +",C: " + (fmt.format((CheckingDeposit*BASIC_INTEREST)+CheckingDeposit)) +")");
				}
				else if(TotalBalance>=1000 && TotalBalance<=5000)
				{
					System.out.println("We have added interest to your account! (S: " + (fmt.format((SavingsDeposit*PREMIUM_INTEREST) + SavingsDeposit)) + ",C: " + (fmt.format((CheckingDeposit*PREMIUM_INTEREST) + CheckingDeposit)) +")");
				}
				else if(TotalBalance>5000)
				{
					System.out.println("We have added interest to your account! (S: " +(fmt.format((SavingsDeposit*PLATINUM_INTEREST)+SavingsDeposit)) + ",C: " + (fmt.format((CheckingDeposit*PLATINUM_INTEREST)+CheckingDeposit)) +")");
				}
		}




		if(Choice==3)					//transfer options
		{
			System.out.println("Transfer Money Options:");
			System.out.println("1. Transfer from Checking to Savings");
			System.out.println("2. Transfer from Savings to Checking");
			System.out.println("3. Cancel");
			System.out.print("Your Choice: ");
			TransferChoice=scan.nextInt();
			System.out.println("     ");
			switch (TransferChoice)
				{
					case 1: TransferChoice= 1;
							break;
					case 2: TransferChoice=2;
							break;
					case 3: TransferChoice=3;
							break;
					default: break;
				}
				if(TransferChoice==1)
				{
					System.out.print("Amount to Transfer from Checking to Savings: ");
					Transfer=scan.nextInt();
					if(Transfer>CheckingDeposit)
					{
						System.out.println("Invalid Choice. You do not have that much in your Checking");
						System.out.println("After this transaction your balance is: " + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
					}
					else
					{
						System.out.println("You Transferred $" + Transfer + " to Savings");
						SavingsDeposit=SavingsDeposit+Transfer;
						CheckingDeposit=CheckingDeposit-Transfer;
						TotalBalance=CheckingDeposit+SavingsDeposit;
						System.out.println("After this transaction your balance is: " + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
					}
				}
				else if(TransferChoice==2)
				{
					System.out.print("Amount to Transfer from Savings to Checking: ");
					Transfer=scan.nextInt();
					if(Transfer>SavingsDeposit)
					{
						System.out.println("Invalid Choice. You do not have that much in your Savings");
						System.out.println("After this transaction your balance is: " + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
					}
					else
					{
						System.out.println("You Transferred $" + Transfer + "To Checking");
						CheckingDeposit=CheckingDeposit+Transfer;
						SavingsDeposit=SavingsDeposit-Transfer;
						TotalBalance=CheckingDeposit+SavingsDeposit;
						System.out.println("After this transaction your balance is: " + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
					}
				}
					else if(TransferChoice==3)
					{
						System.out.println("Transfer Cancelled");
						System.out.println("After this transaction your balance is: "  + fmt.format(TotalBalance) + "(S:"+fmt.format(SavingsDeposit) + ",C:" +fmt.format(CheckingDeposit)+")");
					}

			}
			if(Choice==3)
			{
				if(TotalBalance>0 && TotalBalance<1000)
						{
							System.out.println("We have added interest to your account! (S: " +(fmt.format((SavingsDeposit*BASIC_INTEREST)+SavingsDeposit)) +",C: " + (fmt.format((CheckingDeposit*BASIC_INTEREST)+CheckingDeposit)) +")");
						}
						else if(TotalBalance>=1000 && TotalBalance<=5000)
						{
							System.out.println("We have added interest to your account! (S: " + (fmt.format((SavingsDeposit*PREMIUM_INTEREST) + SavingsDeposit)) + ",C: " + (fmt.format((CheckingDeposit*PREMIUM_INTEREST) + CheckingDeposit)) +")");
						}
						else if(TotalBalance>5000)
						{
							System.out.println("We have added interest to your account! (S: " +(fmt.format((SavingsDeposit*PLATINUM_INTEREST)+SavingsDeposit)) + ",C: " + (fmt.format((CheckingDeposit*PLATINUM_INTEREST)+CheckingDeposit)) +")");
						}
			}
			if(Choice==4) 				//terminates the banking program
			{
				System.out.println("Banking Cancelled");
			}
		}
	}
