import java.text.NumberFormat;
/*-------------------------------------------------------------------------
// AUTHOR: Taylor Collins
// FILENAME: BankAccount.java
// SPECIFICATION: this program creates the methods to be used in the Assignment5.java program.
// FOR: CSE 110- homework #5 MWF 9:40-10:30
// TIME SPENT: 3 hours
//----------------------------------------------------------------------*/
public class BankAccount
{
	private String enteredID;    //initizialize variables to be used
	double Checking,Savings;
	private double enteredAmount2;
	private double enteredAmount1,enteredAmount;
	private double Balance;
	final double LOW_INTEREST=.025;
	final double MEDIUM_INTEREST=.035;
	final double HIGH_INTEREST=.045;
	NumberFormat fmt = NumberFormat.getCurrencyInstance();

	public BankAccount() //default constructor
	{
		enteredID="???";
		Balance=0;
	}
	public BankAccount( String initId,double initChecking, double initSavings) //define constructor
	{
		enteredID=initId;
		enteredAmount2=initSavings;
		enteredAmount1=initChecking;
	}

	private String getID() //method used to get the ID
	{
		return enteredID;
	}

	public double getChecking() //method used to get checking
	{
		Checking=enteredAmount1;
		return Checking;
	}

	public double getSavings() //returns savings
	{
		Savings=enteredAmount2;
		return Savings;
	}

	public double getBalance()//adds together checking and savings to return the balance
	{
		Balance=Balance+Checking+Savings;
		return Balance;
	}

	public void setID(String name)
	{
		this.enteredID=name;
	}

	public void deposit(double depositAmount) //checks to make sure the deposit is valid and adds it to checking
	{
		if(depositAmount>0)
		{
			enteredAmount1=enteredAmount1+depositAmount;
		}
	}

	public boolean withdraw(double withdrawAmount) //checks to make sure the withdraw amount is valid then subtracts it from checkings
	{
		boolean result=true;
		if(withdrawAmount>enteredAmount1 || withdrawAmount<0)
		{
			result=false;
		}
		else
		{
			enteredAmount1=enteredAmount1-withdrawAmount;
		}
		return result;
	}

	public void addInterest() //calculates the type of account based on the balance, then adds interest based on that type
	{
		Balance=enteredAmount1+enteredAmount2;
		if(Balance<=1000.00)
		{
			enteredAmount1=enteredAmount1+(enteredAmount1*LOW_INTEREST);
			enteredAmount2=enteredAmount2+(enteredAmount2*LOW_INTEREST);
		}
		else if(Balance>1000.00 && Balance<=5000.00)
		{
			enteredAmount1=enteredAmount1+(enteredAmount1*MEDIUM_INTEREST);
			enteredAmount2=enteredAmount2+(enteredAmount2*MEDIUM_INTEREST);
		}
		else if(Balance>5000.00)
		{
			enteredAmount1=enteredAmount1+(enteredAmount1*HIGH_INTEREST);
			enteredAmount2=enteredAmount2+(enteredAmount2*HIGH_INTEREST);
		}
	}

	public boolean equals(String is) //creates the equals method that checks to see if the ID entered and the stored ID are the same
	{
		boolean compare=false;
		if(is!=null && is.compareTo(enteredID)==0)
		{
			return is.equals(enteredID);
		}
		return compare;
	}

	public String toString() //returns information about the account
	{
		return("\n"+ "ID:" +enteredID +  "\n" + "checking Balance:" +fmt.format(enteredAmount1) + "\n" +"Savings Balance:" +fmt.format(enteredAmount2));
	}
}
