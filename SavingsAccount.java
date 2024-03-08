/*Kazi Shadman Sakib*/
/*Roll- 97*/
import java.util.*;
public class SavingsAccount extends BankAccount{
	private Date currentDate; 
	private static int limitBalance = 100;
	public static double interestRate = 4;
	public SavingsAccount(String accountName,int accountNumber){
		super(accountName,accountNumber);
	}
	public SavingsAccount(String accountName,int accountNumber,int balance){
		super(accountName,accountNumber,balance);
	}
	public void withdraw(int ammount){
		if(getAccountBalance()-ammount >= limitBalance && getAccountBalance()>ammount){
			int accountBalance = getAccountBalance() - ammount;
			setAccountBalance(accountBalance);
			Date withdrawDate = new Date();
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " debited by BDT " + ammount + " on " + withdrawDate);
			System.out.println();
		}
		else{
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " could not withdraw BDT " + ammount);
			System.out.println();
		}
	}
	@Override
	public void transfer(int ammount,SavingsAccount account){
		Date transferDate = new Date();
		if(getAccountBalance()-ammount >= limitBalance && getAccountBalance()>ammount){
			int accountBalance = getAccountBalance() - ammount;
			setAccountBalance(accountBalance);
			account.deposit(ammount);
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " debited by BDT " + ammount + " on " + transferDate + ". Fund transfered to " + account.getAccountNumber());
			System.out.println();
		}
		else{
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " could not transfer BDT " + ammount + " to the A/C " + account.getAccountNumber());
			System.out.println();
		}
	}
	@Override
	public void transfer(int ammount,CurrentAccount account){
		Date transferDate = new Date();
		if(getAccountBalance()-ammount >= limitBalance && getAccountBalance()>ammount){
			int accountBalance = getAccountBalance() - ammount;
			setAccountBalance(accountBalance);
			account.deposit(ammount);
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " debited by BDT " + ammount + " on " + transferDate + ". Fund transfered to " + account.getAccountNumber());
			System.out.println();
		}
		else{
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " could not transfer BDT " + ammount + " to the A/C " + account.getAccountNumber());
			System.out.println();
		}
	}
	public void yearEndInterest(){
		Date currentDate = new Date();
		long currentUpdate = currentDate.getTime();
		long previousUpdate = getLastUpdate().getTime();
		int yearPassed = (int)((double)(currentUpdate - previousUpdate) / (3600.0 * 24.0 * 365));
		int accountBalance = (int)(getAccountBalance() * (1.0 + yearPassed * (interestRate / 100.0)));
		setAccountBalance(accountBalance);
		setLastUpdate(currentDate);
	}
}